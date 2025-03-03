document.addEventListener("DOMContentLoaded", async () => {
    const movieDetails = document.getElementById("movieDetails");

    // Get IMDb ID from URL
    const urlParams = new URLSearchParams(window.location.search);
    const imdbID = urlParams.get("imdbID");

    if (!imdbID) {
        movieDetails.innerHTML = "<p>Movie not found. Please try again.</p>";
        return;
    }

    // Fetch movie details from OMDb API
    const apiKey = "d61cd2df"; // Replace with your actual API key
    const url = `https://www.omdbapi.com/?i=${imdbID}&apikey=${apiKey}`;

    try {
        const response = await fetch(url);
        const movie = await response.json();

        if (movie.Response === "True") {
            movieDetails.innerHTML = `
                <div class="movie-info">
                    <img src="${movie.Poster}" alt="${movie.Title}">
                    <h2>${movie.Title} (${movie.Year})</h2>
                    <p><strong>Genre:</strong> ${movie.Genre}</p>
                    <p><strong>Director:</strong> ${movie.Director}</p>
                    <p><strong>Actors:</strong> ${movie.Actors}</p>
                    <p><strong>Plot:</strong> ${movie.Plot}</p>
                    <p><strong>IMDB Rating:</strong> ⭐ ${movie.imdbRating}</p>
                    <p><strong>Runtime:</strong> ${movie.Runtime}</p>
                    <p><strong>Released:</strong> ${movie.Released}</p>
                    <p><strong>Box Office:</strong> ${movie.BoxOffice || "N/A"}</p>
                </div>
            `;
        } else {
            movieDetails.innerHTML = `<p>Movie details not available.</p>`;
        }
    } catch (error) {
        console.error("Error fetching movie details:", error);
        movieDetails.innerHTML = `<p>Failed to load movie details. Please try again later.</p>`;
    }
});
