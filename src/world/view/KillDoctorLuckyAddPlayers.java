package world.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import world.ReadOnlyWorld;
import world.control.Features;

/**
 * Panel to add the players in the game.
 */
public class KillDoctorLuckyAddPlayers extends JPanel {
  private static final long serialVersionUID = 1L;
  private JPanel jpanelLabel;

  private JPanel jpanelMiddle;
  private JPanel jpanelHuman;
  private JPanel jpanelHuman1;
  private JPanel jpanelHuman2;
  private JPanel jpanelHumanLabel;
  private JPanel jpanelHumanBox;

  private JPanel jpanelButton;

  private JTextField jtTextPlayerName;
  private JComboBox<String> jtTextPlayerRoomName;
  private JComboBox<String> jtTextPlayerItemsLimit;

  private JLabel jlabelTitle;
  private JLabel jlabelPlayerName;
  private JLabel jlabelPlayerRoomName;
  private JLabel jlabelPlayerItems;

  private JButton jbHumanAddButton;
  private JButton jbComputerAddButton;
  private JButton jbPlayButton;

  /**
   * Panel to add the players in the game.
   * 
   * @param model readonly model object.
   */
  public KillDoctorLuckyAddPlayers(ReadOnlyWorld model) {
    if (model == null) {
      throw new IllegalArgumentException("model object cannot be null");
    }
    jpanelLabel = new JPanel();

    jpanelMiddle = new JPanel();
    jpanelHuman = new JPanel();
    jpanelHuman1 = new JPanel();
    jpanelHuman2 = new JPanel();
    jpanelHumanLabel = new JPanel();
    jpanelHumanBox = new JPanel();

    jpanelButton = new JPanel();

    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    jpanelMiddle.setLayout(new BoxLayout(jpanelMiddle, BoxLayout.X_AXIS));
    jpanelHumanBox.setLayout(new BoxLayout(jpanelHumanBox, BoxLayout.Y_AXIS));
    jpanelHumanLabel.setLayout(new BoxLayout(jpanelHumanLabel, BoxLayout.Y_AXIS));
    jpanelHuman.setLayout(new BoxLayout(jpanelHuman, BoxLayout.Y_AXIS));
    this.jbHumanAddButton = new JButton("Add Human Player");
    this.jbComputerAddButton = new JButton("Add Computer Player");
    this.jbPlayButton = new JButton("Play");
    this.jlabelTitle = new JLabel("Add Players to the game");
    this.jlabelPlayerName = new JLabel("Player Name:");
    this.jlabelPlayerRoomName = new JLabel("Player Room Name:");
    this.jlabelPlayerItems = new JLabel("Player Item's Limit:");
    this.jtTextPlayerName = new JTextField(20);
    this.jtTextPlayerRoomName = new JComboBox<String>(model.getRooms());
    String[] itemLimits = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    this.jtTextPlayerItemsLimit = new JComboBox<String>(itemLimits);

    jpanelHumanLabel.add(jlabelPlayerName);
    jpanelHumanLabel.add(jlabelPlayerRoomName);
    jpanelHumanLabel.add(jlabelPlayerItems);
    jpanelHumanBox.add(jtTextPlayerName);
    jpanelHumanBox.add(jtTextPlayerRoomName);
    jpanelHumanBox.add(jtTextPlayerItemsLimit);
    jpanelHuman1.add(jpanelHumanLabel);
    jpanelHuman1.add(jpanelHumanBox);
    jpanelHuman1.add(jbHumanAddButton);
    jpanelHuman2.add(jbComputerAddButton);
    jpanelHuman.add(jpanelHuman1, BorderLayout.WEST);
    jpanelHuman.add(jpanelHuman2);

    jpanelLabel.add(jlabelTitle);
    jpanelMiddle.add(jpanelHuman);
    jpanelButton.add(jbPlayButton);
    this.add(jpanelLabel);
    this.add(jpanelMiddle);
    this.add(jpanelButton);
    jlabelTitle.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
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
   * All the actions for buttons will be called in this method.
   * 
   * @param f Feature object.
   */
  public void setFeatures(Features f) {
    if (f == null) {
      throw new IllegalArgumentException("feature object cannot be null");
    }
    jbHumanAddButton.addActionListener(l -> f.addHumanPlayer(jtTextPlayerName.getText(),
        jtTextPlayerRoomName.getSelectedItem().toString(),
        jtTextPlayerItemsLimit.getSelectedItem().toString()));
    jbComputerAddButton.addActionListener(l -> f.addComputerPlayer());
    jbPlayButton.addActionListener(l -> f.startGame());
  }

}
