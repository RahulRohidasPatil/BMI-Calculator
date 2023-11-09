package com.rahulpatil.bmi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFact {
    public static class Status {
        @JsonProperty("verified")
        private boolean verified;

        @JsonProperty("sentCount")
        private int sentCount;

        @JsonProperty("feedback")
        private String feedback;

        // Add getters and setters

        @Override
        public String toString() {
            return "Status{" +
                    "verified=" + verified +
                    ", sentCount=" + sentCount +
                    ", feedback='" + feedback + '\'' +
                    '}';
        }
    }

    @JsonProperty("_id")
    private String id;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("user")
    private String user;

    @JsonProperty("text")
    private String text;

    @JsonProperty("__v")
    private int version;

    @JsonProperty("source")
    private String source;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("type")
    private String type;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("deleted")
    private boolean deleted;

    @JsonProperty("used")
    private boolean used;

    @Override
    public String toString() {
        return "CatFact [id=" + id + ", status=" + status + ", user=" + user + ", text=" + text + ", version=" + version
                + ", source=" + source + ", updatedAt=" + updatedAt + ", type=" + type + ", createdAt=" + createdAt
                + ", deleted=" + deleted + ", used=" + used + "]";
    }

}
