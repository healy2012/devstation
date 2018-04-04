import QtQuick 2.0

Item {
    id: textItem
    width: 80
    height: 20
//    anchors.top:100
//    anchors.left:parent.left
//        anchors.leftMargin: 100
//        anchors.horizontalCenter: parent.horizontalCenter
//        anchors.verticalCenter: banner.verticalCenter

    Text {
        id: stocText
        anchors.verticalCenter: parent.verticalCenter
        anchors.left:parent.left
        color: "#ffffff"
        font.family: "Abel"
        font.pointSize: 40
        text: "Stoc"
    }
    Text {
        id: qtText
        anchors.verticalCenter: parent.verticalCenter
        anchors.left: stocText.right
        color: "#5caa15"
        font.family: "Abel"
        font.pointSize: 40
        text: "Qt2"
    }
    MouseArea
    {
        hoverEnabled: true
        anchors.fill: parent
        onClicked:
        {
            console.log("text be clicked"+textItem.update())
        }
    }
}
