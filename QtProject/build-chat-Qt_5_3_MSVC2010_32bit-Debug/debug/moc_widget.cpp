/****************************************************************************
** Meta object code from reading C++ file 'widget.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.3.2)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../chat2/widget.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'widget.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.3.2. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_Widget_t {
    QByteArrayData data[22];
    char stringdata[383];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Widget_t, stringdata) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Widget_t qt_meta_stringdata_Widget = {
    {
QT_MOC_LITERAL(0, 0, 6),
QT_MOC_LITERAL(1, 7, 28),
QT_MOC_LITERAL(2, 36, 0),
QT_MOC_LITERAL(3, 37, 5),
QT_MOC_LITERAL(4, 43, 24),
QT_MOC_LITERAL(5, 68, 7),
QT_MOC_LITERAL(6, 76, 16),
QT_MOC_LITERAL(7, 93, 15),
QT_MOC_LITERAL(8, 109, 20),
QT_MOC_LITERAL(9, 130, 21),
QT_MOC_LITERAL(10, 152, 19),
QT_MOC_LITERAL(11, 172, 34),
QT_MOC_LITERAL(12, 207, 1),
QT_MOC_LITERAL(13, 209, 39),
QT_MOC_LITERAL(14, 249, 16),
QT_MOC_LITERAL(15, 266, 19),
QT_MOC_LITERAL(16, 286, 15),
QT_MOC_LITERAL(17, 302, 23),
QT_MOC_LITERAL(18, 326, 12),
QT_MOC_LITERAL(19, 339, 20),
QT_MOC_LITERAL(20, 360, 15),
QT_MOC_LITERAL(21, 376, 6)
    },
    "Widget\0on_tableWidget_doubleClicked\0"
    "\0index\0on_textUnderline_clicked\0checked\0"
    "on_clear_clicked\0on_save_clicked\0"
    "on_textcolor_clicked\0on_textitalic_clicked\0"
    "on_textbold_clicked\0"
    "on_fontComboBox_currentFontChanged\0f\0"
    "on_fontsizecomboBox_currentIndexChanged\0"
    "on_close_clicked\0on_sendfile_clicked\0"
    "on_send_clicked\0processPendingDatagrams\0"
    "sentFileName\0currentFormatChanged\0"
    "QTextCharFormat\0format"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Widget[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
      15,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    1,   89,    2, 0x08 /* Private */,
       4,    1,   92,    2, 0x08 /* Private */,
       6,    0,   95,    2, 0x08 /* Private */,
       7,    0,   96,    2, 0x08 /* Private */,
       8,    0,   97,    2, 0x08 /* Private */,
       9,    1,   98,    2, 0x08 /* Private */,
      10,    1,  101,    2, 0x08 /* Private */,
      11,    1,  104,    2, 0x08 /* Private */,
      13,    1,  107,    2, 0x08 /* Private */,
      14,    0,  110,    2, 0x08 /* Private */,
      15,    0,  111,    2, 0x08 /* Private */,
      16,    0,  112,    2, 0x08 /* Private */,
      17,    0,  113,    2, 0x08 /* Private */,
      18,    1,  114,    2, 0x08 /* Private */,
      19,    1,  117,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void, QMetaType::QModelIndex,    3,
    QMetaType::Void, QMetaType::Bool,    5,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Bool,    5,
    QMetaType::Void, QMetaType::Bool,    5,
    QMetaType::Void, QMetaType::QFont,   12,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::QString,    2,
    QMetaType::Void, 0x80000000 | 20,   21,

       0        // eod
};

void Widget::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Widget *_t = static_cast<Widget *>(_o);
        switch (_id) {
        case 0: _t->on_tableWidget_doubleClicked((*reinterpret_cast< QModelIndex(*)>(_a[1]))); break;
        case 1: _t->on_textUnderline_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 2: _t->on_clear_clicked(); break;
        case 3: _t->on_save_clicked(); break;
        case 4: _t->on_textcolor_clicked(); break;
        case 5: _t->on_textitalic_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 6: _t->on_textbold_clicked((*reinterpret_cast< bool(*)>(_a[1]))); break;
        case 7: _t->on_fontComboBox_currentFontChanged((*reinterpret_cast< QFont(*)>(_a[1]))); break;
        case 8: _t->on_fontsizecomboBox_currentIndexChanged((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 9: _t->on_close_clicked(); break;
        case 10: _t->on_sendfile_clicked(); break;
        case 11: _t->on_send_clicked(); break;
        case 12: _t->processPendingDatagrams(); break;
        case 13: _t->sentFileName((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 14: _t->currentFormatChanged((*reinterpret_cast< const QTextCharFormat(*)>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObject Widget::staticMetaObject = {
    { &QWidget::staticMetaObject, qt_meta_stringdata_Widget.data,
      qt_meta_data_Widget,  qt_static_metacall, 0, 0}
};


const QMetaObject *Widget::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Widget::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_Widget.stringdata))
        return static_cast<void*>(const_cast< Widget*>(this));
    return QWidget::qt_metacast(_clname);
}

int Widget::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QWidget::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 15)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 15;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 15)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 15;
    }
    return _id;
}
QT_END_MOC_NAMESPACE
