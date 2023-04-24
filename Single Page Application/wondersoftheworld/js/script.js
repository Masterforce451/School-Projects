(function (global) {

//Sitenin çalışması için gerekli dosyaların değişkenlere atanması
var dc = {};
var indexSnippetHtml = "snippets/index-snippet.html";
var ancientWondersCategories_json ="json/ancient_wonders_categories.json";
var wondersCategories_json ="json/wonders_categories.json";
var ancientWondersCategoriesHTML = "snippets/ancient-wonders-categories.html";
var wondersCategoriesHTML = "snippets/wonders-categories.html";
var wondersInCategoryHtml = "snippets/wonders-in-category.html";
var wonderPageHtml = "snippets/wonder-page.html";

//kategorilerden ya da menüden seçilen harikalardan birinin 
dc.loadWonder = function (short_name) {
  showLoading("#main-content");
  if      (short_name =="GPG")  {wonderUrl = "http://myjson.dit.upm.es/api/bins/daq7";} //Great Pyramid of Giza
  else if (short_name == "HGB") {wonderUrl = "http://myjson.dit.upm.es/api/bins/a24z";} //Hanging Gardens of Babylon
  else if (short_name == "TOA") {wonderUrl = "http://myjson.dit.upm.es/api/bins/a9ur";} //Temple of Artemis at Ephesus
  else if (short_name == "SOZ") {wonderUrl = "http://myjson.dit.upm.es/api/bins/erw3";} //Statue of Zeus at Olympia
  else if (short_name == "MOH") {wonderUrl = "http://myjson.dit.upm.es/api/bins/j9xf";} //Mausoleum of Halicarnassus
  else if (short_name == "COR") {wonderUrl = "http://myjson.dit.upm.es/api/bins/25hr";} //Colossus of Rhodes
  else if (short_name == "LOA") {wonderUrl = "http://myjson.dit.upm.es/api/bins/hdbz";} //Lighthouse of Alexandria
  else if (short_name == "GWC") {wonderUrl = "http://myjson.dit.upm.es/api/bins/30cv";} //Great Wall of China
  else if (short_name == "CI")  {wonderUrl = "http://myjson.dit.upm.es/api/bins/g31b";} //Chichén Itzá
  else if (short_name == "P")   {wonderUrl = "http://myjson.dit.upm.es/api/bins/3fsf";} //Petra
  else if (short_name == "MP")  {wonderUrl = "http://myjson.dit.upm.es/api/bins/7xtr";} //Machu Picchu
  else if (short_name == "CR")  {wonderUrl = "http://myjson.dit.upm.es/api/bins/85jj";} //Christ the Redeemer
  else if (short_name == "C")   {wonderUrl = "http://myjson.dit.upm.es/api/bins/cnkv";} //Colosseum
  else if (short_name == "TM")  {wonderUrl = "http://myjson.dit.upm.es/api/bins/269j";} //Taj Mahal
  $ajaxUtils.sendGetRequest(wonderUrl, loadWonderPage);
};

//İki kategoriden birini yüklemek için ayrı ayrı iki fonksiyon
dc.loadAncientWonders = function () {
  showLoading("#main-content");
  $ajaxUtils.sendGetRequest(ancientWondersCategories_json,loadAncientWondersHtml);
};

dc.loadWonders = function () {
  showLoading("#main-content");
  $ajaxUtils.sendGetRequest(wondersCategories_json,loadWondersHtml);
};

//Herhangi bir harika sayfasını yükleme fonksiyonu
function loadWonderPage (wonderUrl) {
  $ajaxUtils.sendGetRequest(wonderPageHtml,function (wonderHtml) {
        var menuItemsViewHtml =buildMenuItemsViewHtml(wonderUrl,wonderHtml);
        insertHtml("#main-content", menuItemsViewHtml);
    },
    false);
}

var insertHtml = function (selector, html) {
  var targetElem = document.querySelector(selector);
  targetElem.innerHTML = html;
};

//Sayfa yüklenirken ajax loaderın ekrana verilmesi
var showLoading = function (selector) {
  var html = "<div class='text-center'>";
  html += "<img src='images/ajax-loader.gif'></div>";
  insertHtml(selector, html);
};

//Küme parantezlerinden kurtulmak için fonksiyon
var insertProperty = function (string, propName, propValue) {
  var propToReplace = "{{" + propName + "}}";
  string = string.replace(new RegExp(propToReplace, "g"), propValue);
  return string;
}

document.addEventListener("DOMContentLoaded", function (event) {
  showLoading("#main-content");
  $ajaxUtils.sendGetRequest(indexSnippetHtml,function (responseText) {
      document.querySelector("#main-content")
      .innerHTML = responseText;
    },
    false);
});


//Antik harikalar ve harikalar sayfalarını oluşturmak için fonksiyonlar
function loadAncientWondersHtml (categories) {
  $ajaxUtils.sendGetRequest(ancientWondersCategoriesHTML,function (categoriesTitleHtml) {
      $ajaxUtils.sendGetRequest(wondersInCategoryHtml,function (categoryHtml) {
          var categoriesViewHtml =loadWonderCategoryHtml(categories,categoriesTitleHtml,categoryHtml);
          insertHtml("#main-content", categoriesViewHtml);
        },false);
      },false);
}

function loadWondersHtml (categories) {
  $ajaxUtils.sendGetRequest(wondersCategoriesHTML,function (categoriesTitleHtml) {
      $ajaxUtils.sendGetRequest(wondersInCategoryHtml,function (categoryHtml) {
          var categoriesViewHtml =loadWonderCategoryHtml(categories,categoriesTitleHtml,categoryHtml);
          insertHtml("#main-content", categoriesViewHtml);
        },false);
      },false);
}


//Kategoriler sayfalarına eklenecek html'leri oluşturmak için fonksiyon
function loadWonderCategoryHtml(categories,categoriesTitleHtml,categoryHtml) {
  var finalHtml = categoriesTitleHtml;
  finalHtml += "<section class='row'>";
  for (var i = 0; i < categories.length; i++) { //fonksiyon her iki kategori için de 7 kere dönecek
    var html = categoryHtml;
    var name = "" + categories[i].name;
    var short_name = categories[i].short_name;
    html =insertProperty(html, "name", name);
    html =insertProperty(html,"short_name",short_name);
    finalHtml += html;
  }
  return finalHtml;
}

//Bir harika sayfasında bulunan ana elemanların insertProperty ile sayfaya eklenmesi
function buildMenuItemsViewHtml(categoryMenuItems,wonderHtml) {
  wonderHtml =insertProperty(wonderHtml,"name",categoryMenuItems.wonder_info.name);                //harikanın adı,
  wonderHtml =insertProperty(wonderHtml,"description",categoryMenuItems.wonder_info.description);  //tanımı,
  wonderHtml =insertProperty(wonderHtml,"short_name",categoryMenuItems.wonder_info.short_name);    //ve short_name'i kullanılarak wonder-page-html'den sayfanın fotoğrafı sayfaya 
  var finalHtml = wonderHtml;                                                                      //eklenir
  return finalHtml;
}

//menü ikonunun başka yere tıklama durumunda ya da menüden bir sayfa seçilmesi durumunda 100 ms gecikmeyle küçülmesi için fonksiyon
$(function (Collapse_Menu) {              //100ms gecikmeyi şu yüzden ekledim, menüde 14 tane eleman olduğu için alt taraflardan bi eleman seçilmesi durumunda collapse direkt 
  $("#navbarToggle").blur(function () {   //devreye girince, sayfa komutu düzgün algılayamıyor
    var screenWidth = window.innerWidth;  //ben de bunu tıklamadan sonra 100 ms gecikme koyarak çözdüm
      setTimeout(() => {
        $("#collapsable-nav").collapse('hide');
      }, 100);
  });
});

global.$dc = dc;

})(window);
