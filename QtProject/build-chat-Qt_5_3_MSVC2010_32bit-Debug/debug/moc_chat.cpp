/****************************************************************************
** Meta object code from reading C++ file 'chat.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.3.2)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../chat2/chat.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'chat.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.3.2. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_chat_t {
    QByteArrayData data[20];
    char stringdata[346];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_chat_t, stringdata) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_chat_t qt_meta_stringdata_chat = {
    {
QT_MOC_LITERAL(0, 0, 4),
QT_MOC_LITERAL(1, 5, 12),
QT_MOC_LITERAL(2, 18, 0),
QT_MOC_LITERAL(3, 19, 19),
QT_MOC_LITERAL(4, 39, 23),
QT_MOC_LITERAL(5, 63, 15),
QT_MOC_LITERAL(6, 79, 16),
QT_MOC_LITERAL(7, 96, 16),
QT_MOC_LITERAL(8, 113, 15),
QT_MOC_LITERAL(9, 129, 20),
QT_MOC_LITERAL(10, 150, 24),
QT_MOC_LITERAL(11, 175, 7),
QT_MOC_LITERAL(12, 183, 21),
QT_MOC_LITERAL(13, 205, 19),
QT_MOC_LITERAL(14, 225, 34),
QT_MOC_LITERAL(15, 260, 1),
QT_MOC_LITERAL(16, 262, 39),
QT_MOC_LITERAL(17, 302, 20),
QT_MOC_LITERAL(18, 323, 15),
QT_MOC_LITERAL(19, 339, 6)
    },
    "chat\0sentFileName\0\0on_sendfile_clicked\0"
    "processPendingDatagrams\0on_send_clicked\0"
    "on_close_clicked\0on_clear_clicked\0"
    "on_save_clicked\0on_textcolor_clicked\0"
    "on_textUnderline_clicked\0checked\0"
    "on_textitalic_clicked\0on_textbold_clicked\0"
    "on_fontComboBox_currentFontChanged\0f\0"
    "on_fontsizecomboBox_currentIndexChanged\0"
    "currentFormatChanged\0QTextCharFormat\0"
    "format"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_chat[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      14,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   84,    2, 0x08 /* Private */,
       3,    0,   87,    2, 0x08 /* Private */,
       4,    0,   88,    2, 0x08 /* Private */,
       5,    0,   89,    2, 0x08 /* Private */,
       6,    0,   90,    2, 0x08 /* Private */,
       7,    0,   91,    2, 0x08 /* Private */,
       8,    0,   92,    2, 0x08 /* Private */,
       9,    0,   93,    2, 0x08 /* Private */,
      10,    1,   94,    2, 0x08 /* Private */,
      12,    1,   97,    2, 0x08 /* Private */,
      13,    1,  100,    2, 0x08 /* Private */,
      14,    1,  103,    2, 0x08 /* Private */,
      16,    1,  106,    2, 0x08 /* Private */,
      17,    1,  109,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Bool,   11,
    QMetaType::Void, QMetaType::Bool,   11,
    QMetaType::Void, QMetaType::Bool,   11,
    QMetaType::Void, QMetaType::QFont,   15,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void, 0x80000000 | 18,   19,

       0        // eod
};

void chat::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        chat *_t = static_cast<chat *>(_o);
        switch (_id) {
        case 0: _t->sentFileName((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 1: _t->on_sendfile_clicked(); break;
        case 2: _t->processPendingDatagrams(); break;
        case 3: _t->on_send_clicked(); break;
        case 4: _t->on_close_clicked(); break;
        case 5: _t->on_clear_clicked(); break;
        case 6: _t->on_save_clicked(); break;
        case 7: _t->on_textcolor_clicked(); break;
        case 8: _t->on_textUnderline_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 9: _t->on_textitalic_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 10: _t->on_textbold_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 11: _t->on_fontComboBox_currentFontChanged((*reinterpret_cast< QFont(*)>(_a[1]))); break;
        case 12: _t->on_fontsizecomboBox_currentIndexChanged((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 13: _t->currentFormatChanged((*reinterpret_cast< const QTextCharFormat(*)>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObject chat::staticMetaObject = {
    { &QDialog::staticMetaObject, qt_meta_stringdata_chat.data,
      qt_meta_data_chat,  qt_static_metacall, 0, 0}
};


const QMetaObject *chat::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *chat::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_chat.stringdata))
        return static_cast<void*>(const_cast< chat*>(this));
    return QDialog::qt_metacast(_clname);
}

int chat::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QDialog::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 14)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 14;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 14)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 14;
    }
    return _id;
}
QT_END_MOC_NAMESPACE
