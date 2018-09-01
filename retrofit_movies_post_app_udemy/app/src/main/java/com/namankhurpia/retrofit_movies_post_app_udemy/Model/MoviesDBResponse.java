package com.namankhurpia.retrofit_movies_post_app_udemy.Model;

import android.os.Parcel;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MoviesDBResponse implements Parcelable{


        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("total_results")//here babe
        @Expose
        private Integer totalMovies;
        @SerializedName("total_pages")
        @Expose
        private Integer totalPages;
        @SerializedName("results")//here babe
        @Expose
        private List<Movies> Movies = new ArrayList<>();
        public final static Parcelable.Creator<MoviesDBResponse> CREATOR = new Creator<MoviesDBResponse>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public MoviesDBResponse createFromParcel(Parcel in) {
                return new MoviesDBResponse(in);
            }

            public MoviesDBResponse[] newArray(int size) {
                return (new MoviesDBResponse[size]);
            }

        };

        protected MoviesDBResponse(Parcel in) {
            this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.totalMovies = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
            in.readList(this.Movies, (com.namankhurpia.retrofit_movies_post_app_udemy.Model.Movies.class.getClassLoader()));
        }

        public MoviesDBResponse() {
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getTotalMovies() {
            return totalMovies;
        }

        public void setTotalMovies(Integer totalMovies) {
            this.totalMovies = totalMovies;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<Movies> getMovies() {
            return Movies;
        }

        public void setMovies(List<Movies> Movies) {
            this.Movies = Movies;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(page);
            dest.writeValue(totalMovies);
            dest.writeValue(totalPages);
            dest.writeList(Movies);
        }

        public int describeContents() {
            return 0;
        }


}
