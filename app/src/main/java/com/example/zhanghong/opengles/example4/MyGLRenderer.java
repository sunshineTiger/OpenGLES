package com.example.zhanghong.opengles.example4;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.example.zhanghong.opengles.example3.Square;
import com.example.zhanghong.opengles.example3.Triangle;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    private Triangle triangle;
    Square quad;

    // Rotational angle and speed (NEW)
    private float angleTriangle = 0.0f; // (NEW)
    private float angleQuad = 0.0f;     // (NEW)
    private float speedTriangle = 0.5f; // (NEW)
    private float speedQuad = -0.4f;    // (NEW)

    // Constructor
    public MyGLRenderer(Context context) {
        // Set up the buffers for these shapes
        triangle = new Triangle();
        quad = new Square();
    }

    // Call back when the surface is first created or re-created
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.5f, 0.0f, 0.0f, 0.0f);//set color's clear-value to black
        gl.glClearDepthf(1.0f);// Set depth's clear-value to farthest
        gl.glEnable(GL10.GL_DEPTH_TEST);//Enables depth-buffer for hidden surface removal
        gl.glDepthFunc(GL10.GL_LEQUAL);//The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);      // Disable dithering for better performance
    }

    // Call back after onSurfaceCreated() or whenever the window's size changes
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;   // To prevent divide by zero
        float aspect = (float) width / height;
        // Set the viewport (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);// Select projection matrix
        gl.glLoadIdentity();                 // Reset projection matrix
        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    // Call back to draw the current frame.
    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear color and depth buffers using clear-values set earlier
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();                 // Reset model-view matrix
        gl.glTranslatef(-0.0f, 0.0f, -6.0f); // Translate left and into the screen
        gl.glRotatef(angleTriangle, 0.0f, 1.0f, 0.0f); // Rotate the triangle about the y-axis (NEW)
        triangle.draw(gl);                   // Draw triangle

//        gl.glLoadIdentity();                 // Reset the mode-view matrix (NEW)
//        gl.glTranslatef(1.5f, 0.0f, -6.0f);  // Translate right and into the screen (NEW)
//        gl.glRotatef(angleQuad, 1.0f, 0.0f, 0.0f); // Rotate the square about the x-axis (NEW)
//        quad.draw(gl);                       // Draw quad

        // Update the rotational angle after each refresh (NEW)
        angleTriangle += speedTriangle; // (NEW)
//        angleQuad += speedQuad;         // (NEW)
    }
}