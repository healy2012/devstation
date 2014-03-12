//当前日期
var NowDateText;
var today=new Date();
  function initArray(){
	 this.length=initArray.arguments.length
	 for(var i=0;i<this.length;i++)
	 this[i+1]=initArray.arguments[i]
  }
	 var d=new initArray( "星期日","星期一","星期二","星期三","星期四","星期五","星期六" );
  if (window.navigator.userAgent.indexOf("Firefox")>=1)
	{NowDateText=today.getYear()+1900+"年";}
  else
	{NowDateText=today.getFullYear()+"年";}
	{NowDateText+=today.getMonth()+1+"月";}
	{NowDateText+=today.getDate()+"日 ";}
	{NowDateText+=d[today.getDay()+1];}


//选项卡
//name选项卡名称；num当前选项卡编号
function setTab(name,num,n){
	for(i=1;i<=n;i++){
		var menu=document.getElementById(name+i);
		var con=document.getElementById(name+"_"+"con"+i);
		menu.className=i==num?"now":"";
  		con.style.display=i==num?"block":"none"; 
	}
}





















