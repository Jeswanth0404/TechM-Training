import React, { useState } from "react";

const MovieForm = ({ onAddMovie }) => {
  const [title, setTitle] = useState("");
  const [year, setYear] = useState("");
  const [poster, setPoster] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!title || !year || !poster) {
      alert("All fields are required!");
      return;
    }

    const newMovie = {
      Title: title,
      Year: year,
      Poster: poster,
    };

    onAddMovie(newMovie);

    setTitle("");
    setYear("");
    setPoster("");
  };

  return (
    <div className="card p-3 my-3">
      <h4>Add a New Movie</h4>
      <form onSubmit={handleSubmit}>
        <div className="mb-2">
          <label className="form-label">Movie Title</label>
          <input
            type="text"
            className="form-control"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="Enter movie title"
          />
        </div>

        <div className="mb-2">
          <label className="form-label">Release Year</label>
          <input
            type="text"
            className="form-control"
            value={year}
            onChange={(e) => setYear(e.target.value)}
            placeholder="Enter release year"
          />
        </div>

        <div className="mb-2">
          <label className="form-label">Poster URL</label>
          <input
            type="text"
            className="form-control"
            value={poster}
            onChange={(e) => setPoster(e.target.value)}
            placeholder="Enter poster image URL"
          />
        </div>

        <button type="submit" className="btn btn-success">Add Movie</button>
      </form>
    </div>
  );
};

export default MovieForm;
