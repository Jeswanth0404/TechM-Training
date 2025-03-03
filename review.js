document.addEventListener("DOMContentLoaded", () => {
    const movieTitleInput = document.getElementById("movieTitle");
    const reviewTextInput = document.getElementById("reviewText");
    const submitReviewButton = document.getElementById("submitReview");
    const reviewList = document.getElementById("reviewList");

    // Load reviews from local storage
    function loadReviews() {
        const reviews = JSON.parse(localStorage.getItem("reviews")) || [];
        reviewList.innerHTML = "<h2>Reviews</h2>"; // Reset list
        reviews.forEach((review, index) => displayReview(review, index));
    }

    // Display a single review
    function displayReview(review, index) {
        const reviewItem = document.createElement("div");
        reviewItem.classList.add("review-item");
        reviewItem.innerHTML = `
            <h3>${review.movie}</h3>
            <p>${review.text}</p>
            <button class="delete-review" data-index="${index}">Delete</button>
        `;
        reviewList.appendChild(reviewItem);
    }

    // Save review
    submitReviewButton.addEventListener("click", () => {
        const movieTitle = movieTitleInput.value.trim();
        const reviewText = reviewTextInput.value.trim();

        if (movieTitle === "" || reviewText === "") {
            alert("Please enter both movie title and review.");
            return;
        }

        const reviews = JSON.parse(localStorage.getItem("reviews")) || [];
        const newReview = { movie: movieTitle, text: reviewText };
        reviews.push(newReview);
        localStorage.setItem("reviews", JSON.stringify(reviews));

        movieTitleInput.value = "";
        reviewTextInput.value = "";
        loadReviews();
    });

    // Delete review
    reviewList.addEventListener("click", (event) => {
        if (event.target.classList.contains("delete-review")) {
            const index = event.target.getAttribute("data-index");
            const reviews = JSON.parse(localStorage.getItem("reviews")) || [];
            reviews.splice(index, 1);
            localStorage.setItem("reviews", JSON.stringify(reviews));
            loadReviews();
        }
    });

    loadReviews(); // Initialize reviews on page load
});
