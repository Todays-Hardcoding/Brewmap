// 스크롤 위치에 따라 네비게이션 고정
let checkMenu = () => {
  //console.log(yOffset)
  if (yOffset > 0) {
    document.body.classList.add("nav-sticky");
  } else {
    document.body.classList.remove("nav-sticky");
  }
};

// 스크롤 체크 및 함수 실행
window.addEventListener("scroll", () => {
  yOffset = window.pageYOffset;
  checkMenu();
});

// 검색버튼 on/off
let openCloseSearch = () => {
  if (document.getElementById("nav-search-input").style.display === "block") {
    document.getElementById("nav-search-input").style.display = "none";
  } else {
    document.getElementById("nav-search-input").style.display = "block";
  }
};

