TEMPLATE        = app
TARGET          = sqlbrowser

QT              += sql widgets

HEADERS         = browser.h connectionwidget.h qsqlconnectiondialog.h
SOURCES         = main.cpp browser.cpp connectionwidget.cpp qsqlconnectiondialog.cpp

FORMS           = browserwidget.ui qsqlconnectiondialog.ui
build_all:!build_pass {
    CONFIG -= build_all
    CONFIG += release
}

wince*: {
    DEPLOYMENT_PLUGIN += qsqlite
}