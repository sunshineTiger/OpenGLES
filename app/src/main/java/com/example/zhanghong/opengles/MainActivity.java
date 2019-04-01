package com.example.zhanghong.opengles;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("OpenGLSample01");
        mGLSurfaceView=new MyGLSurfaceView(this);
        setContentView(mGLSurfaceView);
    }
}
