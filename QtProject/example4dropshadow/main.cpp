#include <QDir>
#include <QGuiApplication>
#include <QQmlEngine>
#include <QQmlFileSelector>
#include <QQuickView> //Not using QQmlApplicationEngine because many examples don't have a Window{}
#include <QQmlContext>

int main(int argc, char* argv[])
{
    QGuiApplication app(argc,argv);
    app.setOrganizationName("Qt Project");
    app.setOrganizationDomain("qt-project.org");
    app.setApplicationName(QFileInfo(app.applicationFilePath()).baseName());
    QQuickView view;
    if (qgetenv("QT_QUICK_CORE_PROFILE").toInt()) {
        QSurfaceFormat f = view.format();
        f.setProfile(QSurfaceFormat::CoreProfile);
        f.setVersion(4, 4);
        view.setFormat(f);
    }
    view.connect(view.engine(), SIGNAL(quit()), &app, SLOT(quit()));
    new QQmlFileSelector(view.engine(), &view);
    view.setSource(QUrl("qrc:/dropshadow.qml"));
    view.setResizeMode(QQuickView::SizeRootObjectToView);
    view.setFlags(Qt::Window|Qt::FramelessWindowHint);
    view.setColor(QColor(Qt::transparent));
//    view.setFlags(Qt::Tool|Qt::CustomizeWindowHint);

    if (QGuiApplication::platformName() == QLatin1String("qnx") ||
          QGuiApplication::platformName() == QLatin1String("eglfs")) {
        view.showFullScreen();
    } else {
        view.show();
    }

    view.rootContext()->setContextProperty("mainwindow",&view);
    return app.exec();
}
