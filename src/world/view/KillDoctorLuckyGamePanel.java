package world.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import world.ReadOnlyWorld;
import world.control.Features;

/**
 * Panel to play the game, which also consist world map.
 *
 */
public class KillDoctorLuckyGamePanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private final ReadOnlyWorld model;
  private JPanel map;
  private JPanel gamePlay;
  private JPanel gamePlay1;
  private JPanel gamePlay2;
  private JPanel gamePlay3;
  private JPanel gamePlay4;

  private JLabel picLabel;
  private JLabel jlClueslabel;
  private JLabel jlPlayerTurn;
  private JLabel jlGameRules;
  private JLabel jlPlayers;

  private BufferedImage myPictureTest;

  /**
   * game panel constructor which initializes all the fields.
   * 
   * @param model readonly object.
   */
  public KillDoctorLuckyGamePanel(ReadOnlyWorld model) {
    if (model == null) {
      throw new IllegalArgumentException("model object cannot be null");
    }
    this.model = model;
    map = new JPanel();
    gamePlay = new JPanel();
    gamePlay1 = new JPanel();
    gamePlay2 = new JPanel();
    gamePlay3 = new JPanel();
    gamePlay4 = new JPanel();
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    gamePlay.setPreferredSize(new Dimension(800, 200));
    gamePlay.setLayout(new BoxLayout(gamePlay, BoxLayout.Y_AXIS));
    myPictureTest = model.getWorldMap();
    picLabel = new JLabel(new ImageIcon(myPictureTest));
    jlClueslabel = new JLabel();
    jlPlayerTurn = new JLabel();
    jlPlayers = new JLabel();
    jlGameRules = new JLabel("<html>Press 1 to Look Around<br/>Press 2 to Pick Item<br/>Press"
        + " 3 to Attack Target<br/>Press 4 to Move Pet<br/>"
        + "Click on a room in world to Move Player</html>");
    map.add(picLabel);
    gamePlay1.add(jlPlayerTurn);
    gamePlay2.add(jlPlayers);
    gamePlay3.add(jlClueslabel);
    gamePlay4.add(jlGameRules);
    gamePlay.add(gamePlay1);
    gamePlay.add(gamePlay2);
    gamePlay.add(gamePlay3);
    gamePlay.add(gamePlay4);
    this.add(map);
    this.add(gamePlay);
    /*
     * map.setMaximumSize(new Dimension(500, Integer.MAX_VALUE)); map.setBorder(new
     * LineBorder(Color.WHITE, 5));
     */
    jlClueslabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 50));
  }

  @Override
  public void paintComponent(Graphics g) {
    if (g == null) {
      throw new IllegalArgumentException("graphic object cannot be null");
    }
    super.paintComponent(g);
    Graphics2D graphicsObj = (Graphics2D) g;
    Border border = new LineBorder(Color.blue, 3, true);
    this.setBorder(border);
    graphicsObj.setColor(Color.white);
    graphicsObj.fillRect(0, 0, getWidth(), getHeight());
    graphicsObj.setColor(Color.blue);
  }

  /**
   * clues and the graph updated the game.
   */
  public void updateClues() {
    jlClueslabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    jlClueslabel.setText(model.getPlayerClues());
    jlClueslabel.setText("<html>" + model.getPlayerClues().replaceAll("\n", "<br/>") + "</html>");
    jlPlayerTurn.setText(model.getPlayerNameTurn());
    jlPlayers.setText(model.getPlayers());
    myPictureTest = model.getWorldMap();
    picLabel.setIcon(new ImageIcon(myPictureTest));
  }

  /**
   * All the actions will be called in this method.
   * 
   * @param f Feature object.
   */
  public void setFeatures(Features f) {
    if (f == null) {
      throw new IllegalArgumentException("feature object cannot be null");
    }
  }
}
