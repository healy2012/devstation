/**
 * TODO
 * @author zhangchao
 * Create on 2011-9-9
 */
package cn.emag.global.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import cn.emag.framework.exception.ServiceException;

public class ConfigManager {

	private static Map<String, ConfigManager> configs = new HashMap<String, ConfigManager>();

	private FileInfo fileInfo;

	private static Lock lock = new ReentrantLock();

	private ConfigManager(String fileName) {
		this.fileInfo = new FileInfo(fileName);
	}

	public static ConfigManager getInstance(String fileName) {
		Assert.hasText(fileName, "fileName is null!");
		if (!configs.containsKey(fileName)) {
			lock.lock();
			try {
				if (!configs.containsKey(fileName)) {
					configs.put(fileName, new ConfigManager(fileName));
				}
			} finally {
				lock.unlock();
			}
		}
		return configs.get(fileName);
	}

	public String getStringConfigItem(String key, String defaultValue) {
		return this.fileInfo.getConfigItem(key, defaultValue);
	}

	public String getStringConfigItem(String key) {
		return this.getStringConfigItem(key, null);
	}

	public Integer getIntegerConfigItem(String key) {
		String value = getStringConfigItem(key);
		return (Integer) ConvertUtils.convert(value, Integer.class);
	}

	public Integer getIntegerConfigItem(String key, Integer defaultVal) {
		Integer value = getIntegerConfigItem(key);
		return (value != null) ? value : defaultVal;
	}

	public Long getLongConfigItem(String key) {
		String value = getStringConfigItem(key);
		return (Long) ConvertUtils.convert(value, Long.class);
	}

	public Long getLongConfigItem(String key, Long defaultVal) {
		Long value = getLongConfigItem(key);
		return (value != null) ? value : defaultVal;
	}

	public Boolean getBooleanConfigItem(String key) {
		String value = getStringConfigItem(key);
		return (Boolean) ConvertUtils.convert(value, Boolean.class);
	}

	public Boolean getBooleanConfigItem(String key, Boolean defaultVal) {
		Boolean value = getBooleanConfigItem(key);
		return value != null ? value : defaultVal;
	}
	
	private static class FileInfo extends Properties {

		private static final long serialVersionUID = 701401858270953970L;

		private static Log log = LogFactory.getLog(FileInfo.class);

		private String fileName;

		private String filePath;

		private String extension;

		private long lastModifyTime;

		private Lock lock = new ReentrantLock();

		public FileInfo(String fileName) {
			this.fileName = fileName;
			this.extension = getExtension();
			this.filePath = buildFilePath();
			this.loadProperties();
		}

		private void loadProperties() {
			try {
				String path = Thread.currentThread().getContextClassLoader()
						.getResource(this.filePath).getPath();
				Resource resource = new FileSystemResource(path);
				long modifyTime = resource.getFile().lastModified();
				if (modifyTime != lastModifyTime) {
					lock.lock();
					try {
						if (modifyTime != lastModifyTime) {
							super.load(resource.getInputStream());
							lastModifyTime = modifyTime;
							log.info("重新加载["
									+ resource.getFile().getCanonicalPath()
									+ "]文件。");
						}
					} finally {
						lock.unlock();
					}
				}
			} catch (IOException e) {
				log.error("加载[" + this.fileName + "." + this.extension
						+ "]文件出错，原因：" + e.getMessage(), e);
				throw new ServiceException(e.getMessage(), e);
			}
		}

		private String buildFilePath() {
			return new StringBuilder("..").append(File.separator).append("conf")
					.append(File.separator).append(this.fileName).append(".")
					.append(this.extension).toString();
		}

		public String getConfigItem(String key, String defaultValue) {
			loadProperties();
			return super.getProperty(key, defaultValue);
		}

		private String getExtension() {
			return "properties";
		}
	}
}
