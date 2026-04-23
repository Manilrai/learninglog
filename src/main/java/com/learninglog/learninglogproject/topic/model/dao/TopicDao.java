package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DbConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TopicDao {
    public static boolean insertTopic(Topic topic)
    throws SQLException {
        String name = topic.getname();
        int userId = topic.getUserId();
        Timestamp createdAt = topic.getCreatedAt();
        Timestamp updatedAt = topic.getUpdatedAt();

        String query = "INSERT INTO topic (name, user_id, createdat, updatedat)" +
                "VALUE(?,?,?,?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query);
        ) {
            st.setString(1, name);
            st.setInt(2, userId);
            st.setTimestamp(3, createdAt);
            st.setTimestamp(4, updatedAt);
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static List<Topic> fetchTopics()
    throws SQLException{

        String  query="SELECT * FROM topic";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            ResultSet rs = st.executeQuery();
            List<Topic> topicList = new ArrayList<>();
            while (rs.next()){
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp crDate = rs.getTimestamp("createdat");
                Timestamp upDate = rs.getTimestamp("updatedat");

                Topic topicObj = new Topic(id,name, userId, crDate, upDate);
                topicList.add(topicObj);
            }
            return  topicList;
        }
    }
    public Topic fetchTopicById(int id) throws SQLException, IOException {
        String query = "SELECT * FROM topic WHERE id = ?";
        try(Connection conn =DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createDate = rs.getTimestamp("createDat");
                Timestamp updateDate = rs.getTimestamp("updateDat");

                Topic topic = new Topic(id, name, userId, createDate, updateDate);
                return topic;
            }
            else {
                return null;
            }
        }
    }

    public boolean updateTopic(int id, String name) throws SQLException, IOException{
        String query = "UPDATE topic SET name = ? WHERE id = ?";

        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setInt(2, id);
            int updatedRows = st.executeUpdate();
            if (updatedRows > 0){
                return true;
            }
            else {
                return false;
            }
        }
    }
}
