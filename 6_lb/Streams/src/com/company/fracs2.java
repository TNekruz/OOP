//package com.company;
//import javax.swing.*;
//import javax.swing.filechooser.FileFilter;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.geom.Rectangle2D;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//
//
//public class fracs2 extends Thread{
//    public int displaySize;
//    public JImageDisplay display;
//    public FractalGenerator fractalGenerator;
//    public Rectangle2D.Double range;
//    public int rowsRemaining;
//    JComboBox comboBox;
//    Button buttonSave;
//    Button buttonReset;
//    boolean enabled = true;
//
//    public fracs2(int displaySize) {
//        this.displaySize = displaySize;
//        this.range = new Rectangle2D.Double();
//        this.fractalGenerator = new Mandelbrot();
//        this.display = new JImageDisplay(displaySize, displaySize);
//    }
//
//    public fracs2() {
//
//    }
//
//    public void createAndShowGUI() {
//        JFrame frame = new JFrame("Fractal Explorer");
//
//        JPanel panel = new JPanel();
//        JLabel label = new JLabel("Fractal: ");
//        comboBox = new JComboBox();
//        comboBox.addItem("Mandelbrot");
//        comboBox.addItem("Tricorn");
//        comboBox.addItem("Burning Ship");
//        panel.add(label);
//        panel.add(comboBox);
//        comboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // String selectItem = (String) comboBox.getSelectedItem();
//                String selectItem = (String) comboBox.getSelectedItem();
//                /*switch (selectItem) {
//                    case "Tricorn": {fractalGenerator = new Tricorn(); }
//                    case "Burning Ship": {fractalGenerator = new BurningShip();label.setText(selectItem);fractalGenerator.getInitialRange(range);drawFractal();}
//                    default: {fractalGenerator = new Mandelbrot();}
//                }*/
//                if (selectItem == "Tricorn")
//                {
//                    fractalGenerator = new Tricorn();
//                    label.setText(selectItem);
//                    fractalGenerator.getInitialRange(range);
//                    run();
//                }
//
//                if (selectItem == "Burning Ship")
//                {
//                    fractalGenerator = new BurningShip();
//                    label.setText(selectItem);
//                    fractalGenerator.getInitialRange(range);
//                    run();
//                }
//
//                if (selectItem == "Mandelbrot")
//                {
//                    fractalGenerator = new Mandelbrot();
//                    label.setText(selectItem);
//                    fractalGenerator.getInitialRange(range);
//                    run();
//                }
//
//            }
//        });
//        frame.getContentPane().add(panel, BorderLayout.NORTH);
//
//
//        buttonReset = new Button("Reset");
//        buttonReset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fractalGenerator.getInitialRange(range);
//                run();
//            }
//        });
//        buttonSave = new Button("Save");
//        buttonSave.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser jFileChooser = new JFileChooser();
//                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
//                jFileChooser.setFileFilter(filter);
//                jFileChooser.setAcceptAllFileFilterUsed(false);
//                if (jFileChooser.showSaveDialog(display) == JFileChooser.APPROVE_OPTION){
//                    File file = jFileChooser.getSelectedFile();
//                    try {
//                        ImageIO.write(display.image, "png", file);
//                    } catch (IOException exception) {
//                        JOptionPane.showMessageDialog(display, exception.getMessage(),
//                                "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
//                    } catch (NullPointerException exception) {
//                        JOptionPane.showMessageDialog(display, "Save error",
//                                "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
//            }
//        });
//        JPanel btnContainer = new JPanel();
//        btnContainer.add(buttonReset);
//        btnContainer.add(buttonSave);
//        frame.getContentPane().add(btnContainer, BorderLayout.SOUTH);
//
//        frame.addMouseListener(new MouseListener() {
//
//            /**
//             * Invoked when the mouse button has been clicked (pressed
//             * and released) on a component.
//             *
//             * @param e the event to be processed
//             */
//            public void mouseClicked(MouseEvent e) {
//                if(enabled) {
//                    double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
//                    double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, e.getY());
//                    fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
//                    run();
//                }
////            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
////            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, e.getY());
////            System.out.println(Double.toString(xCoord) + " x " + Double.toString(yCoord));
//            }
//
//            /**
//             * Invoked when a mouse button has been pressed on a component.
//             *
//             * @param e the event to be processed
//             */
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            /**
//             * Invoked when a mouse button has been released on a component.
//             *
//             * @param e the event to be processed
//             */
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            /**
//             * Invoked when the mouse enters a component.
//             *
//             * @param e the event to be processed
//             */
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            /**
//             * Invoked when the mouse exits a component.
//             *
//             * @param e the event to be processed
//             */
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
//
//        frame.getContentPane().add(display, BorderLayout.CENTER);
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setResizable(false);
//    }
//    public void run(){
//        //public void drawFractal() {
////        double xCoord, yCoord;
////        for (int x = 0; x < displaySize; x++) {
////            for (int y = 0; y < displaySize; y++) {
////                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
////                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
////                int iterations = fractalGenerator.numIterations(xCoord, yCoord);
////                int rgbColor;
////                if (iterations == -1) {
////                    rgbColor = 0;
////                } else {
////                    float hue = 0.7f + (float) iterations / 200f;
////                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
////                }
////                display.drawPixel(x, y, rgbColor);
////            }
////        }
////        display.repaint();
//
//
//        enableUI(false);
//        rowsRemaining = displaySize;
//        for (int y = displaySize / 2; y < displaySize; y++) {
//            FractalWorker fractal = new FractalWorker(y);
//            fractal.execute();
//        }
//    }
//
//
//    public void enableUI(boolean val)
//    {
//        enabled = val;
//        buttonReset.setEnabled(enabled);
//        buttonSave.setEnabled(enabled);
//        comboBox.setEnabled(enabled);
//        display.setEnabled(enabled);
//    }
//
//    private class FractalWorker extends SwingWorker<Object, Object>{
//
//        private int y;
//        private int[] rgbColors;
//
//        FractalWorker(int y){
//            this.y = y;
//        }
//
//
//
//        /**
//         * Computes a result, or throws an exception if unable to do so.
//         *
//         * <p>
//         * Note that this method is executed only once.
//         *
//         * <p>
//         * Note: this method is executed in a background thread.
//         *
//         * @return the computed result
//         * @throws Exception if unable to compute a result
//         */
//        @Override
//        protected Object doInBackground() throws Exception {
//            this.rgbColors = new int[displaySize];
//            double xCoord, yCoord;
//            for (int x = 0; x < displaySize; x++) {
//                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
//                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
//                int iterations = fractalGenerator.numIterations(xCoord, yCoord);
//                int rgbColor;
//                if (iterations == -1) {
//                    rgbColor = 0;
//                } else {
//                    float hue = 0.7f + (float) iterations / 200f;
//                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
//                }
//                rgbColors[x] = rgbColor;
//            }
//            return null;
//        }
//
//        @Override
//        protected void done() {
//            for(int x = 0; x < displaySize; x++) display.drawPixel(x,y,rgbColors[x]);
//            display.repaint(0,0,y,displaySize,1);
//            rowsRemaining--;
//            if (rowsRemaining == 0){
//                enableUI(true);
//            }
//        }
//    }}
//
//
//
//
//
//class fracs1 extends Thread{
//    fracs2 fr2 = new fracs2();
//
//    public void run(){
//    //public void drawFractal() {
////        double xCoord, yCoord;
////        for (int x = 0; x < displaySize; x++) {
////            for (int y = 0; y < displaySize; y++) {
////                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x);
////                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y);
////                int iterations = fractalGenerator.numIterations(xCoord, yCoord);
////                int rgbColor;
////                if (iterations == -1) {
////                    rgbColor = 0;
////                } else {
////                    float hue = 0.7f + (float) iterations / 200f;
////                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
////                }
////                display.drawPixel(x, y, rgbColor);
////            }
////        }
////        display.repaint();
//
//
//        //enableUI(false);
//        //fr2.rowsRemaining = fr2.displaySize;
//        for (int y = 0; y < fr2.displaySize / 2; y++) {
//            FractalWorker fractal = new FractalWorker(y);
//            fractal.execute();
//        }
//    }
//
//
//    /*public void enableUI(boolean val)
//    {
//        fr2.enabled = val;
//        fr2.buttonReset.setEnabled(fr2.enabled);
//        fr2.buttonSave.setEnabled(fr2.enabled);
//        fr2.comboBox.setEnabled(fr2.enabled);
//        fr2.display.setEnabled(fr2.enabled);
//    }*/
//
//    public class FractalWorker extends SwingWorker<Object, Object>{
//
//        private int y;
//        private int[] rgbColors;
//
//        FractalWorker(int y){
//            this.y = y;
//        }
//
//        @Override
//        protected Object doInBackground() throws Exception {
//            this.rgbColors = new int[fr2.displaySize];
//            double xCoord, yCoord;
//            for (int x = 0; x < fr2.displaySize; x++) {
//                xCoord = FractalGenerator.getCoord(fr2.range.x, fr2.range.x + fr2.range.width, fr2.displaySize, x);
//                yCoord = FractalGenerator.getCoord(fr2.range.y, fr2.range.y + fr2.range.height, fr2.displaySize, y);
//                int iterations = fr2.fractalGenerator.numIterations(xCoord, yCoord);
//                int rgbColor;
//                if (iterations == -1) {
//                    rgbColor = 0;
//                } else {
//                    float hue = 0.7f + (float) iterations / 200f;
//                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
//                }
//                rgbColors[x] = rgbColor;
//            }
//            return null;
//        }
//
//        @Override
//        protected void done() {
//            for(int x = 0; x < fr2.displaySize; x++) fr2.display.drawPixel(x,y,rgbColors[x]);
//            fr2.display.repaint(0,0,y,fr2.displaySize,1);
//            fr2.rowsRemaining--;
//            if (fr2.rowsRemaining == 0){
//                //enableUI(true);
//            }
//        }
//    }}
//    class main {
//        public static void main(String[] args) {
//            fracs2 fractalExplorer = new fracs2(800);
//            fracs1 fractalExplorer1 = new fracs1();
//            fractalExplorer.createAndShowGUI();
//            fractalExplorer.fractalGenerator.getInitialRange(fractalExplorer.range);
//            fractalExplorer.start();
//            fractalExplorer1.start();
//        }
//    }
//
