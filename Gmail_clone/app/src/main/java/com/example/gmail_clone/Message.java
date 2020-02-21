package com.example.gmail_clone;

public class Message {
    private Integer id;
    private String address;
    private String title;
    private String description;
    private String timestamp;
    private boolean isSelected;
    public Message(Integer id, String address, String title, String description,String timestamp) {
        this.id = id;
        this.address = address;
        this.title = title;
        if (description.length()>60) description=description.substring(0,60)+"...";
        this.description = description;
        this.timestamp=timestamp;
        this.isSelected=false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length()>60) description=description.substring(0,60)+"...";
        this.description = description;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public static Integer getAvatar(String s){
        String x=s.toLowerCase();
        if (!s.equals("")){
            switch (x.charAt(0)){
                case 'a':return R.drawable.circle_a;
                case 'b':return R.drawable.circle_b;
                case 'c':return R.drawable.circle_c;
                case 'd':return R.drawable.circle_d;
                case 'e':return R.drawable.circle_e;
                case 'f':return R.drawable.circle_f;
                case 'g':return R.drawable.circle_g;
                case 'h':return R.drawable.circle_h;
                case 'i':return R.drawable.circle_i;
                case 'j':return R.drawable.circle_j;
                case 'k':return R.drawable.circle_k;
                case 'l':return R.drawable.circle_l;
                case 'm':return R.drawable.circle_m;
                case 'n':return R.drawable.circle_n;
                case 'o':return R.drawable.circle_o;
                case 'p':return R.drawable.circle_p;
                case 'q':return R.drawable.circle_q;
                case 'r':return R.drawable.circle_r;
                case 's':return R.drawable.circle_s;
                case 't':return R.drawable.circle_t;
                case 'u':return R.drawable.circle_u;
                case 'v':return R.drawable.circle_v;
                case 'w':return R.drawable.circle_w;
                case 'x':return R.drawable.circle_x;
                case 'y':return R.drawable.circle_y;
                default:return R.drawable.circle_z;
            }
        }
        return -1;
    }
}
