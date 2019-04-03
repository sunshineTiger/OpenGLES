package com.example.zhanghong.opengles.example1;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Context mContext;

    public MyGLRenderer(Context mContext) {
        this.mContext = mContext;
    }

    // Call back when the surface is first created or re-created
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //设置背景颜色
        gl.glClearColor(0.5f, 0.0f, 0.0f, 0.0f);//set color's clear-value to black
        //设置深度值
        gl.glClearDepthf(1.0f);// Set depth's clear-value to farthest
        //开始深度测试
        gl.glEnable(GL10.GL_DEPTH_TEST);//Enables depth-buffer for hidden surface removal
        //设置深度测试的类型
        gl.glDepthFunc(GL10.GL_LEQUAL);//The type of depth testing to do
        //真正精细的透视修正。这一行告诉OpenGL我们希望进行最好的透视修正。这会十分轻微的影响性能。但使得透视图看起来好一点。
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        //开启平滑显示颜色,控制opengl中绘制指定两点间其他点颜色的过渡模式
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        //禁用抖动以获得更好的性能
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance
    }

    // Call back after onSurfaceCreated() or whenever the window's size changes
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float) width / height;
        // Set the viewport (display area) to cover the entire window,将viewport(显示区域)设置为覆盖整个窗口
        gl.glViewport(0, 0, width, height);
        //选择投影矩阵,改变的是坐标系与Surface的映射关系
        gl.glMatrixMode(GL10.GL_PROJECTION);// Select projection matrix
        //重置投影矩阵
        gl.glLoadIdentity();                 // Reset projection matrix
        GLU.gluPerspective(gl, 65, aspect, 0.1f, 100f);
        //选择模型矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        //重置投影矩阵
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //清除
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }
}
