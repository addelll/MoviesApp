package com.popularmovies.vpaliy.data.source.local;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class MoviesContract {

    public static final String CONTENT_AUTHORITY="com.popularmovies.vpaliy";
    public static final String PREFIX="content://";
    public static final Uri BASE_CONTENT_URI=Uri.parse(PREFIX+CONTENT_AUTHORITY);

    public static final String PATH_MOVIE="movie";
    public static final String PATH_MOVIE_DETAILS="movieDetails";
    public static final String PATH_MOST_POPULAR="mostPopular";
    public static final String PATH_HIGHEST_RATED="highestRated";


    private MoviesContract(){
        throw new UnsupportedOperationException("Can't create a class instance");
    }



    public static class MovieEntry implements BaseColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" +PATH_MOVIE;

        public static final String MOVIE_ID="movieId";

        public static final String TABLE_NAME="movies";
        public static final String COLUMN_ORIGINAL_TITLE="originalTitle";
        public static final String COLUMN_OVERVIEW="overview";
        public static final String COLUMN_BUDGET="budget";
        public static final String COLUMN_REVENUE="revenue";
        public static final String COLUMN_RUNTIME="runtime";
        public static final String COLUMN_HOME_PAGE="homePage";
        public static final String COLUMN_POPULARITY="popularity";
        public static final String COLUMN_MOVIE_BACKDROPS="backdrops";
        public static final String COLUMN_POSTER_PATH = "posterPath";
        public static final String COLUMN_RELEASE_DATE = "releaseDate";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_IS_FAVORITE="isFavorite";
        public static final String COLUMN_AVERAGE_VOTE = "voteAverage";
        public static final String COLUMN_VOTE_COUNT = "voteCount";
        public static final String COLUMN_GENRES="genres";
        public static final String COLUMN_BACKDROP_PATH = "backdropPath";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_ORIGINAL_TITLE + " TEXT, " +
                        COLUMN_OVERVIEW + " TEXT, " +
                        COLUMN_RELEASE_DATE + " TEXT, " +
                        COLUMN_POSTER_PATH + " TEXT, " +
                        COLUMN_POPULARITY + " REAL, " +
                        COLUMN_BUDGET+" INTEGER, "+
                        COLUMN_RUNTIME+" INTEGER, "+
                        COLUMN_REVENUE+" INTEGER, "+
                        COLUMN_GENRES+" TEXT, "+
                        COLUMN_HOME_PAGE+" TEXT, "+
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_IS_FAVORITE+" INTEGER, "+
                        COLUMN_AVERAGE_VOTE + " REAL, " +
                        COLUMN_VOTE_COUNT + " INTEGER," +
                        COLUMN_BACKDROP_PATH + " TEXT, " +
                        COLUMN_MOVIE_BACKDROPS + " TEXT " +
                        " );";

        public static final String SQL_DROP_IF_EXISTS="DROP TABLE IF EXISTS "+TABLE_NAME;


        public static final String[] COLUMNS= new String[]{
                _ID,
                COLUMN_ORIGINAL_TITLE,COLUMN_OVERVIEW,
                COLUMN_RELEASE_DATE,COLUMN_POSTER_PATH,
                COLUMN_POPULARITY,COLUMN_BUDGET,
                COLUMN_RUNTIME,COLUMN_REVENUE,
                COLUMN_GENRES,COLUMN_HOME_PAGE,
                COLUMN_TITLE,COLUMN_IS_FAVORITE,
                COLUMN_AVERAGE_VOTE,COLUMN_VOTE_COUNT,
                COLUMN_BACKDROP_PATH,COLUMN_MOVIE_BACKDROPS
        };


    }




    public static class MostPopularEntry implements BaseColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_MOST_POPULAR).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" +
                        CONTENT_AUTHORITY + "/" + PATH_MOVIE+"/"+PATH_MOST_POPULAR;

        public static final String TABLE_NAME="mostPopular";


        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        MovieEntry.MOVIE_ID + " INTEGER NOT NULL, " +
                        " FOREIGN KEY (" + MovieEntry.MOVIE_ID + ") REFERENCES " +
                        MovieEntry.TABLE_NAME + " (" + MovieEntry._ID + ") " + " );";
        public static final String SQL_DROP_IF_EXISTS="DROP TABLE IF EXISTS "+TABLE_NAME;

    }



    public static class MostRatedEntry implements BaseColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_HIGHEST_RATED).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_MOVIE
                        +"/"+PATH_HIGHEST_RATED;

        public static final String TABLE_NAME="favorites";


        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        MovieEntry.MOVIE_ID + " INTEGER NOT NULL, " +
                        " FOREIGN KEY (" + MovieEntry.MOVIE_ID + ") REFERENCES " +
                        MovieEntry.TABLE_NAME + " (" + MovieEntry._ID + ") " + " );";
        public static final String SQL_DROP_IF_EXISTS="DROP TABLE IF EXISTS "+TABLE_NAME;

    }


}
