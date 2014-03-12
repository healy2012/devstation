/**
 * TODO
 * @author zhangchao
 * Create on 2011-9-14
 */
package cn.emag.global.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import cn.emag.framework.exception.ServiceException;

public class XmlConfigManager {
	private static Map<String, XmlConfigManager> configs = new HashMap<String, XmlConfigManager>();

	private XmlFileInfo fileInfo;

	private static Lock lock = new ReentrantLock();

	private XmlConfigManager(String fileName) {
		this.fileInfo = new XmlFileInfo(fileName);
	}

	public static XmlConfigManager getInstance(String fileName) {
		Assert.hasText(fileName, "fileName is null!");
		if (!configs.containsKey(fileName)) {
			lock.lock();
			try {
				if (!configs.containsKey(fileName)) {
					configs.put(fileName, new XmlConfigManager(fileName));
				}
			} finally {
				lock.unlock();
			}
		}
		return configs.get(fileName);
	}

	public Document getDocument() {
		return this.fileInfo.getDocument();
	}

	public Element getRootElement() {
		return this.fileInfo.getRootElement();
	}

	private static class XmlFileInfo {

		private static Log log = LogFactory.getLog(XmlFileInfo.class);

		private String fileName;

		private String filePath;

		private String extension;

		private Document document;

		private long lastModifyTime;

		private Lock lock = new ReentrantLock();

		public XmlFileInfo(String fileName) {
			this.fileName = fileName;
			this.extension = getExtension();
			this.filePath = buildFilePath();
			this.loadXml();
		}

		private void loadXml() {
			try {
				String path = Thread.currentThread().getContextClassLoader()
						.getResource(this.filePath).getPath();
				Resource resource = new FileSystemResource(path);
				long modifyTime = resource.getFile().lastModified();
				if (modifyTime != lastModifyTime) {
					lock.lock();
					try {
						if (modifyTime != lastModifyTime) {
							SAXReader sax = new SAXReader();
							this.document = sax.read(resource.getInputStream());
							lastModifyTime = modifyTime;
							log.info("重新加载["
									+ resource.getFile().getCanonicalPath()
									+ "]文件。");
						}
					} finally {
						lock.unlock();
					}
				}
			} catch (Exception e) {
				log.error("加载[" + this.fileName + "." + this.extension
						+ "]文件出错，原因：" + e.getMessage(), e);
				throw new ServiceException(e.getMessage(), e);
			}
		}

		private String buildFilePath() {
			return new StringBuilder("..").append(File.separator)
					.append("conf").append(File.separator)
					.append(this.fileName).append(".").append(this.extension)
					.toString();
		}

		private String getExtension() {
			return "xml";
		}

		public Document getDocument() {
			this.loadXml();
			return this.document;
		}

		public Element getRootElement() {
			return this.getDocument().getRootElement();
		}
	}
}
