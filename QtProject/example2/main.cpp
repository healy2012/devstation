#include <QApplication>
#include <QQmlApplicationEngine>
#include<QQuickView>
#include<QColor>
#include<QQmlContext>

int main(int argc, char *argv[])
{
//    QApplication app(argc, argv);

//    QQmlApplicationEngine engine;
//    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));

//    return app.exec();

    QApplication app(argc,argv);
        QQuickView viwer;
        //无边框，背景透明
        viwer.setFlags(Qt::Window|Qt::FramelessWindowHint);
        viwer.setColor(QColor(Qt::transparent));
        //加载qml
        viwer.setSource(QUrl(QStringLiteral("qrc:/qml/main.qml")));
        viwer.show();
        //将viewer设置为main.qml属性
        viwer.rootContext()->setContextProperty("mainwindow",&viwer);

//        viwer.setIcon(QIcon(QString("qrc:/Image/sysicon.png")));
//        viwer.winId();
        return app.exec();
}
