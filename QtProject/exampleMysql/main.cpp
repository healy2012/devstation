#include <QApplication>
#include <QQmlApplicationEngine>
#include <QSqlDatabase>
#include <QDebug>
#include <QStringList>
#include <QMessageBox>
int main(int argc, char *argv[])
{

//    QApplication a(argc,argv);
//    qDebug()<<"available drivers";
//    QStringList drivers=QSqlDatabase::drivers();
//    foreach(QString driver,drivers){
//        qDebug()<<driver;
//    }

//    return a.exec();

    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;
    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));

    qDebug()<<"available drivers";
    QStringList drivers=QSqlDatabase::drivers();
    foreach(QString driver,drivers){
            qDebug()<<driver;
        }

    QSqlDatabase db = QSqlDatabase::addDatabase("QMYSQL");
    db.setHostName("localhost");
    db.setDatabaseName("arpg");//数据库名
    db.setUserName("root");
    db.setPassword("emag");
    db.setPort(3306);
    if(!db.open()){
        qDebug()<<"数据库连接失败.";
        db.close();
//        exit(EXIT_FAILURE);
    }

    return app.exec();
}
