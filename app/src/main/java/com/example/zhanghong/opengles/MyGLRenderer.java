package com.example.zhanghong.opengles;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background frame color
        //设置清空屏幕用的颜色，接收四个参数分别是：红色、绿色、蓝色和透明度分量，0表示透明，1.0f相反
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //设置视图的尺寸，这就告诉了OpenGL可以用来渲染surface的大小。
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //清空屏幕，清空屏幕后调用glClearColor(）中设置的颜色填充屏幕；
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
