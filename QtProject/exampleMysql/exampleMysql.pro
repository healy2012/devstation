TEMPLATE = app

QT += core gui qml quick sql

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += console

SOURCES += main.cpp

RESOURCES += qml.qrc

# Additional import path used to resolve QML modules in Qt Creator's code model
QML_IMPORT_PATH =

# Default rules for deployment.
include(deployment.pri)
