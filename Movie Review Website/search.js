document.addEventListener("DOMContentLoaded", () => {
    const searchInput = document.getElementById("search-input");
    const searchButton = document.getElementById("search-button");
    const searchResults = document.getElementById("searchResults");

    // Function to fetch movie data from an API
    async function fetchMovies(query) {
        const apiKey = "d61cd2df"; // Replace with a valid API key
        const url = `https://www.omdbapi.com/?s=${query}&apikey=${apiKey}`;
        try {
            const response = await fetch(url);
            const data = await response.json();
            if (data.Search) {
                displayMovies(data.Search);
            } else {
                searchResults.innerHTML = "<p>No results found.</p>";
            }
        } catch (error) {
            console.error("Error fetching movie data:", error);
            searchResults.innerHTML = "<p>Error fetching movie data. Please try again later.</p>";
        }
    }

    // Function to display movies
    function displayMovies(movies) {
        searchResults.innerHTML = "";
        movies.forEach(movie => {
            const movieCard = document.createElement("div");
            movieCard.classList.add("movie-card");
            movieCard.innerHTML = `
                <img src="${movie.Poster}" alt="${movie.Title}">
                <h3>${movie.Title} (${movie.Year})</h3>
                <a href="details.html?imdbID=${movie.imdbID}">View Details</a>
            `;
            searchResults.appendChild(movieCard);
        });
    }

    // Event listener for search button
    searchButton.addEventListener("click", () => {
        const query = searchInput.value.trim();
        if (query !== "") {
            fetchMovies(query);
        }
    });

    // Event listener for pressing Enter key in search input
    searchInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            searchButton.click();
        }
    });
});
