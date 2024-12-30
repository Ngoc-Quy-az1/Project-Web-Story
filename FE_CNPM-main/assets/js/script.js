// slide

// var swiper = new Swiper(".mySwiper", {
//     cssMode: true,
//     navigation: {
//       nextEl: ".swiper-button-next",
//       prevEl: ".swiper-button-prev",
//     },
//     pagination: {
//       el: ".swiper-pagination",
//     },
//     mousewheel: true,
//     keyboard: true,
//   });
// slide
const GenreEnum = {
  1: "KINH DỊ",
  2: "TRINH THÁM",
  3: "CỔ TÍCH",
  4: "HỒI KÝ",
  5: "TÙY BÚT",
  6: "ONE SHOT",
  7: "GIẢ TƯỞNG",
  8: "TIỂU THUYẾT",
  9: "ACTION",
  10: "TRUYỆN TRANH",
  11: "NGÔN TÌNH",
  12: "KHÔNG XÁC ĐỊNH"
};
// Hàm chuyển đổi số thành tên
function getGenreName(number) {
  return GenreEnum[number] || "Không hợp lệ"; // Trả về tên hoặc thông báo lỗi
}
function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param); // Trả về giá trị tham số
}
const button = document.querySelector('#submitButton'); // Thay ID của nút theo yêu cầu
const inputField = document.querySelector('#inputField'); // Thay ID của input theo yêu cầu

if (button && inputField) {
    button.addEventListener('click', (e) => {
        e.preventDefault();
        // Lấy giá trị từ thẻ input
        const inputValue = inputField.value.trim(); // .trim() để loại bỏ khoảng trắng thừa
        if (inputValue) {
            console.log(`Input value: ${inputValue}`); // Xử lý giá trị input
            window.location.href=`./search.html?title=${inputValue}`
        } else {
            alert('Vui lòng nhập giá trị!');
        }
    });
}
// Lấy tất cả các sao đánh giá
// Lấy tất cả các ngôi sao


// Biến để lưu số sao được chọn


// Hàm để cập nhật màu sắc của các ngôi sao
function updateStarColors(rating) {
    stars.forEach(star => {
        const starValue = parseInt(star.getAttribute('data-value'));
        if (starValue <= rating) {
            star.classList.add('selected'); // Thêm class selected cho sao được chọn
        } else {
            star.classList.remove('selected'); // Loại bỏ class selected cho sao chưa chọn
        }
    });
}
function fetchComments(apiUrl) {
  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return response.json(); // Parse JSON từ response
    })
    .then(data => {
      // Hiển thị dữ liệu trong block
      let commentBlock = document.getElementById('comment-list');
      let listComment = '';
      for (let i = 0; i < data.length; i++) {
        // Thêm mỗi item vào trong <div>
        listComment += `
          <div class="comment-item">
            <div class="comment-header">
              <div class="avatar"></div>
              <div class="username">Người dùng ${i + 1}</div>
            </div>
            <div class="comment-body">
              ${data[i].comment}
              <span class="show-more">...</span>
            </div>
            <div class="comment-rating">
              ${Array.from({ length: data[i].rate }, () => '<i class="fas fa-star"></i>').join('')}
            </div>
          </div>
        `;
      }
      commentBlock.innerHTML = listComment;
    })
    .catch(error => {
      console.error("Error fetching comments:", error);
    });
}
