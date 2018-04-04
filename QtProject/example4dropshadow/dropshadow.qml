import QtQuick 2.0
import QtGraphicalEffects 1.0

Rectangle {
    width: 320;
    height: 240;
    color: "transparent"

    Item {
        id: container;
        anchors.centerIn: parent;
        width:  parent.width;
        height: parent.height;

        Rectangle {
            id: rect
            width: container.width-(2*rectShadow.radius);
            height: container.height-(2 * rectShadow.radius);
            color: "orange";
            radius: 0;
            antialiasing: true;
//            border {
//                width: 1;
//                color: "black";
//            }
            anchors.centerIn: parent;
        }
    }
    DropShadow {
        id: rectShadow;
        anchors.fill: source
        cached: true;
        horizontalOffset: 0;
        verticalOffset: 3;
        radius: 8.0;
        samples: 16;
        color: "#80000000";
        smooth: true;
        source: container;
    }
}
