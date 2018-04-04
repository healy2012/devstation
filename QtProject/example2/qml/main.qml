import QtQuick 2.3

Rectangle {
         id: page
         width: 900; height: 600
         color: "#00000000"
         border.color: "slategrey"

         Image {
             id: skinpic
             x: 1
             y: 1
             width: 900
             height: 600
             fillMode: Image.TileHorizontally
             sourceSize.height: 600
             sourceSize.width: 800
             source: "qrc:/Image/background_mainwnd.png"

             Text {
                 id: title
                 x: 10
                 y: 10
                 width: 125
                 height: 12
                 color: "#ffffff"
                 text: "3600安全卫士9.2 by 凤鸣琉青"
                 font.pointSize: 9
                 font.family: "微软雅黑"
                 font.pixelSize: 12
             }

             MouseArea {
                 anchors.fill: parent
//                 drag.target: page
//                 drag.axis: Drag.XAndYAxis
                 property variant previousPosition
                 onPressed: {
                     previousPosition = Qt.point(mouseX, mouseY)
                 }
                 onPositionChanged: {
                     if (pressedButtons == Qt.LeftButton) {
                         var dx = mouseX - previousPosition.x
                         var dy = mouseY - previousPosition.y
//                         mainwindow.pos = Qt.point(mainwindow.pos.x + dx,
//                                                     mainwindow.pos.y + dy)
                         mainwindow.setX(mainwindow.x+dx)
                         mainwindow.setY(mainwindow.y+dy)

                     }
                 }
             }

             TabWidget
             {
                 id: tabwindow
                 x: 0;
                 y: 40;
                 width:900
                 height:600
             }

             Image
             {
                 id: logo
                 x: 720
                 y: 40
                 source: "qrc:/Image/logo.png"
             }

             Image
             {
                 id: medal
                 x: 720
                 y: 0
                 source: "qrc:/Image/medal.png"
             }

             SysBtnGroup
             {
                 id: sysbtngrp
                 x: 755
                 y: 0

                 onMin: mainwindow.showMinimized()
                 onClose: mainwindow.close()
             }

         }
     }
