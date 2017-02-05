package com.qhacks.moledetector;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

/**
 * This is where all the networking goes to
 */

public class DAO {
    public static final String SERVER_URL = "http://54.157.204.36";
    public static final String PREDICT_ENDPOINT = "/predict";

    public static void predictMole(String imagePath, OnPredictListener listener) {
        new PredictMoleTask(imagePath, listener).execute();
    }

    public static abstract class OnPredictListener {
        public abstract void onPredict(PredictionResult result);
    }

    private static class PredictMoleTask extends AsyncTask<Void, Void, JSONObject> {
        private String imageFilePath;
        private OnPredictListener onPredicted;

        private PredictMoleTask(String filename, OnPredictListener onPredicted){
            this.imageFilePath = filename;
            this.onPredicted = onPredicted;
        }

        @Override
        protected JSONObject doInBackground(Void... unused) {
            MultipartEntityBuilder multipartEntity = MultipartEntityBuilder.create();
            multipartEntity.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            multipartEntity.addPart("file", new FileBody(new File(this.imageFilePath)));
            HttpPost post = new HttpPost(SERVER_URL + PREDICT_ENDPOINT);
            post.setEntity(multipartEntity.build());
            HttpClient client = new DefaultHttpClient();
            try {
                HttpResponse res =  client.execute(post);
                return new JSONObject(EntityUtils.toString(res.getEntity(), "UTF-8"));
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            } finally {
                client.getConnectionManager().shutdown();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject value) {
            super.onPostExecute(value);
            try {
                this.onPredicted.onPredict(new PredictionResult(value.getDouble("likelihood"),
                        value.getDouble("asymmetry"), value.getDouble("jagedness"),
                        value.getDouble("coloring")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
