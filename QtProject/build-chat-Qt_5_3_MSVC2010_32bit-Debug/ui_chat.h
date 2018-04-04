/********************************************************************************
** Form generated from reading UI file 'chat.ui'
**
** Created by: Qt User Interface Compiler version 5.3.2
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CHAT_H
#define UI_CHAT_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QDialog>
#include <QtWidgets/QFontComboBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpacerItem>
#include <QtWidgets/QTextBrowser>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QToolButton>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_chat
{
public:
    QWidget *layoutWidget;
    QVBoxLayout *verticalLayout;
    QTextBrowser *textBrowser;
    QHBoxLayout *horizontalLayout;
    QFontComboBox *fontComboBox;
    QComboBox *fontsizecomboBox;
    QToolButton *textbold;
    QToolButton *textitalic;
    QToolButton *textUnderline;
    QToolButton *textcolor;
    QToolButton *sendfile;
    QToolButton *save;
    QToolButton *clear;
    QTextEdit *textEdit;
    QHBoxLayout *horizontalLayout_2;
    QSpacerItem *horizontalSpacer;
    QPushButton *close;
    QPushButton *send;
    QWidget *horizontalLayoutWidget;
    QHBoxLayout *horizontalLayout_3;
    QLabel *label;

    void setupUi(QDialog *chat)
    {
        if (chat->objectName().isEmpty())
            chat->setObjectName(QStringLiteral("chat"));
        chat->resize(431, 401);
        layoutWidget = new QWidget(chat);
        layoutWidget->setObjectName(QStringLiteral("layoutWidget"));
        layoutWidget->setGeometry(QRect(10, 40, 411, 351));
        verticalLayout = new QVBoxLayout(layoutWidget);
        verticalLayout->setSpacing(6);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        verticalLayout->setSizeConstraint(QLayout::SetDefaultConstraint);
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        textBrowser = new QTextBrowser(layoutWidget);
        textBrowser->setObjectName(QStringLiteral("textBrowser"));
        QSizePolicy sizePolicy(QSizePolicy::Expanding, QSizePolicy::Expanding);
        sizePolicy.setHorizontalStretch(0);
        sizePolicy.setVerticalStretch(2);
        sizePolicy.setHeightForWidth(textBrowser->sizePolicy().hasHeightForWidth());
        textBrowser->setSizePolicy(sizePolicy);
        textBrowser->setFrameShadow(QFrame::Sunken);
        textBrowser->setOpenExternalLinks(false);

        verticalLayout->addWidget(textBrowser);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        fontComboBox = new QFontComboBox(layoutWidget);
        fontComboBox->setObjectName(QStringLiteral("fontComboBox"));
        QSizePolicy sizePolicy1(QSizePolicy::Fixed, QSizePolicy::Fixed);
        sizePolicy1.setHorizontalStretch(0);
        sizePolicy1.setVerticalStretch(0);
        sizePolicy1.setHeightForWidth(fontComboBox->sizePolicy().hasHeightForWidth());
        fontComboBox->setSizePolicy(sizePolicy1);
        fontComboBox->setMinimumSize(QSize(1, 25));

        horizontalLayout->addWidget(fontComboBox);

        fontsizecomboBox = new QComboBox(layoutWidget);
        fontsizecomboBox->setObjectName(QStringLiteral("fontsizecomboBox"));
        QSizePolicy sizePolicy2(QSizePolicy::Fixed, QSizePolicy::Maximum);
        sizePolicy2.setHorizontalStretch(0);
        sizePolicy2.setVerticalStretch(0);
        sizePolicy2.setHeightForWidth(fontsizecomboBox->sizePolicy().hasHeightForWidth());
        fontsizecomboBox->setSizePolicy(sizePolicy2);
        fontsizecomboBox->setMinimumSize(QSize(0, 25));
        fontsizecomboBox->setEditable(true);

        horizontalLayout->addWidget(fontsizecomboBox);

        textbold = new QToolButton(layoutWidget);
        textbold->setObjectName(QStringLiteral("textbold"));
        textbold->setAutoFillBackground(false);
        QIcon icon;
        icon.addFile(QStringLiteral(":/image/textbold.png"), QSize(), QIcon::Normal, QIcon::Off);
        textbold->setIcon(icon);
        textbold->setIconSize(QSize(24, 24));
        textbold->setCheckable(true);
        textbold->setAutoRaise(true);

        horizontalLayout->addWidget(textbold);

        textitalic = new QToolButton(layoutWidget);
        textitalic->setObjectName(QStringLiteral("textitalic"));
        textitalic->setAutoFillBackground(false);
        QIcon icon1;
        icon1.addFile(QStringLiteral(":/image/textitalic.png"), QSize(), QIcon::Normal, QIcon::Off);
        textitalic->setIcon(icon1);
        textitalic->setIconSize(QSize(24, 24));
        textitalic->setCheckable(true);
        textitalic->setAutoRaise(true);

        horizontalLayout->addWidget(textitalic);

        textUnderline = new QToolButton(layoutWidget);
        textUnderline->setObjectName(QStringLiteral("textUnderline"));
        textUnderline->setAutoFillBackground(false);
        QIcon icon2;
        icon2.addFile(QStringLiteral(":/image/textunder.png"), QSize(), QIcon::Normal, QIcon::Off);
        textUnderline->setIcon(icon2);
        textUnderline->setIconSize(QSize(24, 24));
        textUnderline->setCheckable(true);
        textUnderline->setAutoRaise(true);

        horizontalLayout->addWidget(textUnderline);

        textcolor = new QToolButton(layoutWidget);
        textcolor->setObjectName(QStringLiteral("textcolor"));
        textcolor->setAutoFillBackground(false);
        QIcon icon3;
        icon3.addFile(QStringLiteral(":/image/textcolor.png"), QSize(), QIcon::Normal, QIcon::Off);
        textcolor->setIcon(icon3);
        textcolor->setIconSize(QSize(24, 24));
        textcolor->setCheckable(false);
        textcolor->setAutoRaise(true);

        horizontalLayout->addWidget(textcolor);

        sendfile = new QToolButton(layoutWidget);
        sendfile->setObjectName(QStringLiteral("sendfile"));
        sendfile->setAutoFillBackground(false);
        QIcon icon4;
        icon4.addFile(QStringLiteral(":/image/fileopen.png"), QSize(), QIcon::Normal, QIcon::Off);
        sendfile->setIcon(icon4);
        sendfile->setIconSize(QSize(24, 24));
        sendfile->setCheckable(false);
        sendfile->setAutoRaise(true);

        horizontalLayout->addWidget(sendfile);

        save = new QToolButton(layoutWidget);
        save->setObjectName(QStringLiteral("save"));
        save->setAutoFillBackground(false);
        QIcon icon5;
        icon5.addFile(QStringLiteral(":/image/Floppy.png"), QSize(), QIcon::Normal, QIcon::Off);
        save->setIcon(icon5);
        save->setIconSize(QSize(24, 24));
        save->setCheckable(false);
        save->setAutoRaise(true);

        horizontalLayout->addWidget(save);

        clear = new QToolButton(layoutWidget);
        clear->setObjectName(QStringLiteral("clear"));
        clear->setAutoFillBackground(false);
        QIcon icon6;
        icon6.addFile(QStringLiteral(":/image/Bin (empty).png"), QSize(), QIcon::Normal, QIcon::Off);
        clear->setIcon(icon6);
        clear->setIconSize(QSize(24, 24));
        clear->setCheckable(false);
        clear->setAutoRaise(true);

        horizontalLayout->addWidget(clear);


        verticalLayout->addLayout(horizontalLayout);

        textEdit = new QTextEdit(layoutWidget);
        textEdit->setObjectName(QStringLiteral("textEdit"));
        QSizePolicy sizePolicy3(QSizePolicy::Expanding, QSizePolicy::Maximum);
        sizePolicy3.setHorizontalStretch(0);
        sizePolicy3.setVerticalStretch(1);
        sizePolicy3.setHeightForWidth(textEdit->sizePolicy().hasHeightForWidth());
        textEdit->setSizePolicy(sizePolicy3);
        QFont font;
        font.setFamily(QString::fromUtf8("\345\256\213\344\275\223"));
        font.setPointSize(12);
        textEdit->setFont(font);

        verticalLayout->addWidget(textEdit);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        horizontalSpacer = new QSpacerItem(40, 20, QSizePolicy::Expanding, QSizePolicy::Minimum);

        horizontalLayout_2->addItem(horizontalSpacer);

        close = new QPushButton(layoutWidget);
        close->setObjectName(QStringLiteral("close"));
        close->setMinimumSize(QSize(100, 25));

        horizontalLayout_2->addWidget(close);

        send = new QPushButton(layoutWidget);
        send->setObjectName(QStringLiteral("send"));
        send->setMinimumSize(QSize(100, 25));

        horizontalLayout_2->addWidget(send);


        verticalLayout->addLayout(horizontalLayout_2);

        horizontalLayoutWidget = new QWidget(chat);
        horizontalLayoutWidget->setObjectName(QStringLiteral("horizontalLayoutWidget"));
        horizontalLayoutWidget->setGeometry(QRect(10, 10, 411, 21));
        horizontalLayout_3 = new QHBoxLayout(horizontalLayoutWidget);
        horizontalLayout_3->setObjectName(QStringLiteral("horizontalLayout_3"));
        horizontalLayout_3->setContentsMargins(0, 0, 0, 0);
        label = new QLabel(horizontalLayoutWidget);
        label->setObjectName(QStringLiteral("label"));

        horizontalLayout_3->addWidget(label);


        retranslateUi(chat);

        fontsizecomboBox->setCurrentIndex(3);


        QMetaObject::connectSlotsByName(chat);
    } // setupUi

    void retranslateUi(QDialog *chat)
    {
        chat->setWindowTitle(QApplication::translate("chat", "Dialog", 0));
        fontsizecomboBox->clear();
        fontsizecomboBox->insertItems(0, QStringList()
         << QApplication::translate("chat", "9", 0)
         << QApplication::translate("chat", "10", 0)
         << QApplication::translate("chat", "11", 0)
         << QApplication::translate("chat", "12", 0)
         << QApplication::translate("chat", "13", 0)
         << QApplication::translate("chat", "14", 0)
         << QApplication::translate("chat", "15", 0)
         << QApplication::translate("chat", "16", 0)
         << QApplication::translate("chat", "17", 0)
         << QApplication::translate("chat", "18", 0)
         << QApplication::translate("chat", "19", 0)
         << QApplication::translate("chat", "20", 0)
         << QApplication::translate("chat", "21", 0)
         << QApplication::translate("chat", "22", 0)
        );
#ifndef QT_NO_TOOLTIP
        textbold->setToolTip(QApplication::translate("chat", "\345\212\240\347\262\227", 0));
#endif // QT_NO_TOOLTIP
        textbold->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        textitalic->setToolTip(QApplication::translate("chat", "\345\200\276\346\226\234", 0));
#endif // QT_NO_TOOLTIP
        textitalic->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        textUnderline->setToolTip(QApplication::translate("chat", "\344\270\213\345\210\222\347\272\277", 0));
#endif // QT_NO_TOOLTIP
        textUnderline->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        textcolor->setToolTip(QApplication::translate("chat", "\345\255\227\344\275\223\351\242\234\350\211\262", 0));
#endif // QT_NO_TOOLTIP
        textcolor->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        sendfile->setToolTip(QApplication::translate("chat", "\344\274\240\351\200\201\346\226\207\344\273\266", 0));
#endif // QT_NO_TOOLTIP
        sendfile->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        save->setToolTip(QApplication::translate("chat", "\344\277\235\345\255\230\350\201\212\345\244\251\350\256\260\345\275\225", 0));
#endif // QT_NO_TOOLTIP
        save->setText(QApplication::translate("chat", "...", 0));
#ifndef QT_NO_TOOLTIP
        clear->setToolTip(QApplication::translate("chat", "\346\270\205\347\251\272\350\201\212\345\244\251\350\256\260\345\275\225", 0));
#endif // QT_NO_TOOLTIP
        clear->setText(QApplication::translate("chat", "...", 0));
        textEdit->setHtml(QApplication::translate("chat", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"
"p, li { white-space: pre-wrap; }\n"
"</style></head><body style=\" font-family:'\345\256\213\344\275\223'; font-size:12pt; font-weight:400; font-style:normal;\">\n"
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"></p></body></html>", 0));
        close->setText(QApplication::translate("chat", "\345\205\263\351\227\255(&C)", 0));
        send->setText(QApplication::translate("chat", "\345\217\221\351\200\201(&S)", 0));
        label->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class chat: public Ui_chat {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CHAT_H
