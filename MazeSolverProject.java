import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//We need to use this JFrame like this
public class MazeSolverProject extends JFrame {
    private int [][] maze= {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,1,0,1,0,1,0,0,0,0,0,1},
                            {1,0,1,0,0,0,1,0,1,1,1,0,1},
                            {1,0,0,0,1,1,1,0,0,0,0,0,1},
                            {1,0,1,0,0,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,0,0,1},
                            {1,0,1,0,1,0,0,0,1,1,1,0,1},
                            {1,0,1,0,1,1,1,0,1,0,1,0,1},
                            {1,0,0,0,0,0,0,0,0,0,1,9,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1}
                           };

    //creating a ansPath list storing the values of our answer path's x and y coordinates
    public List<Integer> ansPath = new ArrayList<>();

    //Constructor
    public MazeSolverProject(){
        //Title-> text displays on our window
        setTitle("Vamshi's MazeSolver project");

        //the size of window displayed by default
        setSize(1000,800);
        //this way it will stop running,so we don't want to stop manually in IntelliJ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dfs.searchpath(maze,1,1,ansPath);
    }

    @Override
    public void paint(Graphics g){
        //to make our grid looks in centre
        super.paint(g);
        g.translate(200,200);

        //Coloring each block;
        for(int row=0;row<maze.length;row++){
            for(int col=0;col<maze[0].length;col++){
                Color color;
                switch(maze[row][col]) {
                    case 1 : color=Color.black; break;
                    case 9 : color=Color.red; break;
                    default : color=Color.white; break;

                }
                g.setColor(color);
                g.fillRect(40*col,40*row,40,40);
                g.setColor(Color.gray);
                g.drawRect(40*col,40*row,40,40);
            }
        }

        //making the path colour as green
        for(int p=2;p<ansPath.size()-2;p+=2){
            int pathx=ansPath.get(p);
            int pathy=ansPath.get(p+1);
            g.setColor(Color.GREEN);
            g.fillRect(pathy*40, pathx*40, 40, 40);
        }

        //making starting point as blue
        g.setColor(Color.BLUE);
        g.fillRect(ansPath.get(ansPath.size()-1)*40, ansPath.get(ansPath.size()-2)*40, 40, 40);
    }

    public static void main(String[] args) {
        //creating an object to run our code
        MazeSolverProject mazeSolverProject = new MazeSolverProject();

        //we need to do this to make our application window to be visible
        mazeSolverProject.setVisible(true);
    }
}
