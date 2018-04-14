var addTabs = function (options) {
 var url = window.location.protocol + '//' + window.location.host+"/tenbos/";
 if(options.url ===null || options.url ===undefined){
	 return ;
 }
 options.url = url + options.url;
 id = "tab_" + options.id;
 $(".active").removeClass("active");
 //检测是否有此页面
 if (!$("#" + id)[0]) {
  mainHeight = $(document.body).height() - 90;
  title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
  if (options.close) {
   title += ' <i class="glyphicon glyphicon-remove" tabclose="' + id + '"></i>';
  }
  title += '</a></li>';
  if (options.content) {
   content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
  } else {
   content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe src="' + options.url + '" width="100%" height="700px" title="'+options.title+'" frameborder="no" border="0" marginwidth="0" marginheight="0"  scrolling="yes" allowtransparency="yes"></iframe></div>';
  }
  $(".nav-tabs").append(title);
  $(".tab-content").append(content);
 }
 
 $("#tab_" + id).addClass('active');
 $("#" + id).addClass("active");
};
var closeTab = function (id) {
 if ($("li.active").attr('id') == "tab_" + id) {
  $("#tab_" + id).prev().addClass('active');
  $("#" + id).prev().addClass('active');
 }
 $("#tab_" + id).remove();
 $("#" + id).remove();
};
$(function () {
 mainHeight = $(document.body).height() - 45;
 $('.main-left,.main-right').height(mainHeight);
 $("[addtabs]").click(function () {
  addTabs({ id: $(this).attr("id"), title: $(this).attr('title'), close: true });
 });

 $(".nav-tabs").on("click", "[tabclose]", function (e) {
  id = $(this).attr("tabclose");
  closeTab(id);
 });
});