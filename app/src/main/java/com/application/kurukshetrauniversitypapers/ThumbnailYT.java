package com.application.kurukshetrauniversitypapers;

public class ThumbnailYT {
    private MediumThumb medium;

    public ThumbnailYT(){

    }
    public ThumbnailYT(MediumThumb medium) {
        this.medium = medium;
    }

    public MediumThumb getMedium() {
        return medium;
    }
    public void getMedium(MediumThumb medium){
        this.medium=medium;
    }

    public class MediumThumb {
        private String url;

        public MediumThumb(){

        }

        public MediumThumb(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
    }

