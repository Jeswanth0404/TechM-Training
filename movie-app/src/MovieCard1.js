import React from "react";
import "./App.css";

const MovieCard = ({ movie }) => {
  return (
    <div className="col-md-3 col-sm-6">
      <div className="card mb-4">
        <img src={movie.Poster} className="card-img-top" alt={movie.Title} />
        <div className="card-body">
          <h5 className="card-title">{movie.Title}</h5>
          <p className="card-text">Year: {movie.Year}</p>
        </div>
      </div>
    </div>
  );
};

export default MovieCard;
