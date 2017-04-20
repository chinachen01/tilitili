package com.focus.tilitili.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by focus on 17/4/20.
 */

public class MovieBean {

    /**
     * rating : {"max":10,"average":7.4,"stars":"40","min":0}
     * reviews_count : 295
     * wish_count : 15208
     * douban_site :
     * year : 2009
     * images : {"small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.webp","large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.webp","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p494268647.webp"}
     * alt : https://movie.douban.com/subject/1764796/
     * id : 1764796
     * mobile_url : https://movie.douban.com/subject/1764796/mobile
     * title : 机器人9号
     * do_count : null
     * share_url : https://m.douban.com/movie/subject/1764796
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动画","冒险","奇幻"]
     * collect_count : 72309
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054395/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg"},"name":"伊利亚·伍德","id":"1054395"},{"alt":"https://movie.douban.com/celebrity/1016673/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/33305.jpg","large":"https://img3.doubanio.com/img/celebrity/large/33305.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/33305.jpg"},"name":"詹妮弗·康纳利","id":"1016673"},{"alt":"https://movie.douban.com/celebrity/1017907/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/55994.jpg","large":"https://img3.doubanio.com/img/celebrity/large/55994.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/55994.jpg"},"name":"约翰·C·赖利","id":"1017907"},{"alt":"https://movie.douban.com/celebrity/1036321/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/42033.jpg","large":"https://img3.doubanio.com/img/celebrity/large/42033.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/42033.jpg"},"name":"克里斯托弗·普卢默","id":"1036321"}]
     * current_season : null
     * original_title : 9
     * summary : 机器人9号（伊利亚•伍德 Elijah Wood 饰）突然醒来，发现身边的世界充满危机，四处残败，一片末世景象。9号带着一个画有三个奇怪符号的圆形物体逃到街上，幸遇发明家机器人2号（马丁•兰道 Martin Landau 饰）给自己装上了声音，但2号却不幸被机器怪兽抓走。9号找到了老兵1号（克里斯托弗•普卢默 Christopher Plummer 饰）、机械工5号（约翰•雷利 John C. Reilly 饰）、疯癫画家6号（克里斯品•格拉夫 Crispin Glover 饰）和大力士8号（弗雷德•塔塔绍尔 Fred Tatasciore 饰）。9号与5号擅自出行援救2号，危急时被女武士7号（詹妮佛•康纳利 Jennifer Connelly 饰）救下，但无意中9号却令终极机器兽复活。带着自己从哪里来以及生存使命的问题，9号决定想尽办法制服机器兽，拯救全世界……©豆瓣
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1276787/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg"},"name":"申·阿克","id":"1276787"}]
     * comments_count : 11688
     * ratings_count : 57992
     * aka : ["9：末世决战","九","Number 9","机器人9号"]
     */

    @SerializedName("rating")
    public RatingBean rating;
    @SerializedName("reviews_count")
    public int reviewsCount;
    @SerializedName("wish_count")
    public int wishCount;
    @SerializedName("douban_site")
    public String doubanSite;
    @SerializedName("year")
    public String year;
    @SerializedName("images")
    public ImagesBean images;
    @SerializedName("alt")
    public String alt;
    @SerializedName("id")
    public String id;
    @SerializedName("mobile_url")
    public String mobileUrl;
    @SerializedName("title")
    public String title;
    @SerializedName("do_count")
    public Object doCount;
    @SerializedName("share_url")
    public String shareUrl;
    @SerializedName("seasons_count")
    public Object seasonsCount;
    @SerializedName("schedule_url")
    public String scheduleUrl;
    @SerializedName("episodes_count")
    public Object episodesCount;
    @SerializedName("collect_count")
    public int collectCount;
    @SerializedName("current_season")
    public Object currentSeason;
    @SerializedName("original_title")
    public String originalTitle;
    @SerializedName("summary")
    public String summary;
    @SerializedName("subtype")
    public String subtype;
    @SerializedName("comments_count")
    public int commentsCount;
    @SerializedName("ratings_count")
    public int ratingsCount;
    @SerializedName("countries")
    public List<String> countries;
    @SerializedName("genres")
    public List<String> genres;
    @SerializedName("casts")
    public List<CastsBean> casts;
    @SerializedName("directors")
    public List<DirectorsBean> directors;
    @SerializedName("aka")
    public List<String> aka;

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.4
         * stars : 40
         * min : 0
         */

        @SerializedName("max")
        public int max;
        @SerializedName("average")
        public double average;
        @SerializedName("stars")
        public String stars;
        @SerializedName("min")
        public int min;
    }

    public static class ImagesBean {
        /**
         * small : https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p494268647.webp
         * large : https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p494268647.webp
         * medium : https://img1.doubanio.com/view/movie_poster_cover/spst/public/p494268647.webp
         */

        @SerializedName("small")
        public String small;
        @SerializedName("large")
        public String large;
        @SerializedName("medium")
        public String medium;
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1054395/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/51597.jpg","large":"https://img1.doubanio.com/img/celebrity/large/51597.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/51597.jpg"}
         * name : 伊利亚·伍德
         * id : 1054395
         */

        @SerializedName("alt")
        public String alt;
        @SerializedName("avatars")
        public AvatarsBean avatars;
        @SerializedName("name")
        public String name;
        @SerializedName("id")
        public String id;

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/img/celebrity/small/51597.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/51597.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/51597.jpg
             */

            @SerializedName("small")
            public String small;
            @SerializedName("large")
            public String large;
            @SerializedName("medium")
            public String medium;
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1276787/
         * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg"}
         * name : 申·阿克
         * id : 1276787
         */

        @SerializedName("alt")
        public String alt;
        @SerializedName("avatars")
        public AvatarsBeanX avatars;
        @SerializedName("name")
        public String name;
        @SerializedName("id")
        public String id;

        public static class AvatarsBeanX {
            /**
             * small : https://img3.doubanio.com/img/celebrity/small/1351678808.44.jpg
             * large : https://img3.doubanio.com/img/celebrity/large/1351678808.44.jpg
             * medium : https://img3.doubanio.com/img/celebrity/medium/1351678808.44.jpg
             */

            @SerializedName("small")
            public String small;
            @SerializedName("large")
            public String large;
            @SerializedName("medium")
            public String medium;
        }
    }
}
