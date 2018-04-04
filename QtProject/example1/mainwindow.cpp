#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    ui->textEdit->setText(QString("测试测试"));

    connect(ui->pushButton, SIGNAL(clicked()), this,SLOT(clickConfirm()) );
     connect(ui->pushButton_2, SIGNAL(clicked()), this,SLOT(clickCancel()) );
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::clickConfirm(){
    ui->textEdit->setText(QString("press OK"));
}

void MainWindow::clickCancel(){
    ui->textEdit->setText(QString("press Cancel"));
}

void MainWindow::on_pushButton_clicked()
{
    ui->textEdit->setText(QString("press OK2"));
}

void MainWindow::on_pushButton_3_clicked()
{
    ui->textEdit->setText(QString("press Cancel2"));
}
