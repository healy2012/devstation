#-------------------------------------------------
#
# Project created by QtCreator 2014-11-13T10:36:16
#
#-------------------------------------------------

QT       += core gui qml quick

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = androidexam2
TEMPLATE = app


SOURCES += main.cpp

HEADERS  +=

CONFIG += mobility
MOBILITY = 

ANDROID_PACKAGE_SOURCE_DIR = $$PWD/android

OTHER_FILES += \
    android/AndroidManifest.xml \
    content/Button.qml \
    content/CheckBox.qml \
    content/StockChart.qml \
    content/StockInfo.qml \
    content/StockListModel.qml \
    content/StockListView.qml \
    content/StockModel.qml \
    content/StockSettingsPanel.qml \
    content/StockView.qml \
    content/images/icon-left-arrow.png \
    content/images/wheel.png \
    content/images/wheel-touch.png \
    stocqt.qml \
    content/images/close_hover.png \
    content/images/close_normal.png \
    content/images/close_pressed.png \
    content/images/min_hover.png \
    content/images/min_normal.png \
    content/images/min_pressed.png \
    content/SysBtn.qml \
    content/SysBtnGroup.qml

RESOURCES += \
    stocqt.qrc

