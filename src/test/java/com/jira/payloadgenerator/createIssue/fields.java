package com.jira.payloadgenerator.createIssue;

public class fields {

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public project getProj() {
        return proj;
    }

    public void setProj(project proj) {
        this.proj = proj;
    }

    public issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(issuetype issuetype) {
        this.issuetype = issuetype;
    }

    private String summary;
    private String description;
    private project proj;
    private issuetype issuetype;


    public static class project{
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        private String key;

    }

    public static class issuetype{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

    }


}
