package com.nakashita.personaldashboard.controller;

public class HomePageHtml {
    private StringBuilder sb;

    public HomePageHtml(){
        sb = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">")
                .append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
                .append("<head>")
                .append("<title>Personal dashboard - Swan Launay</title>")
                .append("<meta charset=\"UTF-8\">")
                .append("</head>")
                .append("<body>")
                .append("<div id=\"reactEntryPoint\">")
                .append("</script>")
                .append("</div>")
                .append("</body>")
                .append("</html>");
    }

    @Override
    public String toString(){
        return sb.toString();
    }

}
