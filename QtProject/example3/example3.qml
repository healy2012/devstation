import QtQuick 2.0

Rectangle {
    id: mainwind
    width: 600
    height:400
    color: "#000000"

    Item {
        id: textItem
        width: stocText.width + qtText.width
        height: stocText.height + qtText.height
        anchors.top:parent.top
        anchors.left:parent.left
//        anchors.leftMargin: 100
//        anchors.horizontalCenter: parent.horizontalCenter
//        anchors.verticalCenter: banner.verticalCenter

        function update() {
            console.log("update....")
        }

        Text {
            id: stocText
            anchors.verticalCenter: textItem.verticalCenter
            anchors.left:parent.left
            color: "#ffffff"
            font.family: "Abel"
            font.pointSize: 40
            text: "Stoc"
        }
        Text {
            id: qtText
            anchors.verticalCenter: textItem.verticalCenter
            anchors.left: stocText.right
            color: "#5caa15"
            font.family: "Abel"
            font.pointSize: 40
            text: "Qt"
        }
    }
    Rectangle {
        anchors.top:textItem.bottom
        anchors.topMargin: 20
        Banner{}
    }
}
