/**
 * This Java Class is part of the Impro-Visor Application.
 *
 * Copyright (C) 2015-2016 Robert Keller and Harvey Mudd College.
 *
 * Impro-Visor is free software; you can redistribute it and/or modifyc it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * Impro-Visor is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of merchantability or fitness
 * for a particular purpose. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Impro-Visor; if not, write to the Free Software Foundation, Inc., 51 Franklin
 * St, Fifth Floor, Boston, MA 02110-1301 USA
 */

package imp.trading;

/**
 * @author Zachary Kondak, formerly ActiveTradingWindow
 * changed to ActiveTradingDialog by Robert Keller, so it can be non-modal
 */

import imp.ImproVisor;
import imp.gui.Notate;
import imp.util.TransformFilter;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class ActiveTradingDialog extends javax.swing.JDialog implements TradeListener, ActionListener {
 
    private final ActiveTrading activeTrading;
    private boolean tradingNow = false;
    private boolean userFirst = true;
    private boolean isUserInputError = false;
    private final Integer initialTradeLength = 4;
    public static final java.awt.Point INITIAL_OPEN_POINT = new java.awt.Point(25, 25);

    private final Notate notate;
    
    /**
     * Creates new form ActiveTradingDialog
     * @param notate
     * @param modal
     */
    public ActiveTradingDialog(Notate notate, boolean modal) {
        super(notate, modal);
        this.notate = notate;
        activeTrading = new ActiveTrading(notate);
        initComponents();
        notate.populateGenericGrammarMenu(tradeGrammarMenu);
        populateMusicianList();
        Component[] modes = modeMenu.getMenuComponents();
        for (Component c : modes) {
            JRadioButtonMenuItem mode = (JRadioButtonMenuItem) c;
            mode.addActionListener(this);
        }
        updateMusician();
        updateGUIComponents();
        activeTrading.register(this);
        tradeLengthSpinner.setValue(initialTradeLength);
        loopToggle.setSelected(true);
        updateLoop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        leadingSelector = new javax.swing.ButtonGroup();
        modeSelector = new javax.swing.ButtonGroup();
        transformFileSelector = new javax.swing.ButtonGroup();
        grammarGroup = new javax.swing.ButtonGroup();
        leadSelectors = new javax.swing.JPanel();
        userFirstButton = new javax.swing.JRadioButton();
        improvisorFirstButton = new javax.swing.JRadioButton();
        switchToPassiveTradingButton = new javax.swing.JButton();
        modePanel = new javax.swing.JPanel();
        modeStatus = new javax.swing.JLabel();
        grammarStatus = new javax.swing.JLabel();
        transformStatus = new javax.swing.JLabel();
        controlsPanel = new javax.swing.JPanel();
        processTimeSelector = new javax.swing.JTextField();
        tempoPanel = new javax.swing.JPanel();
        tempoLabel = new javax.swing.JLabel();
        tempoSlider = new javax.swing.JSlider();
        volumePanel = new javax.swing.JPanel();
        volumeLabel = new javax.swing.JLabel();
        volumeSlider = new javax.swing.JSlider();
        playbackControls = new javax.swing.JPanel();
        countToggle = new javax.swing.JCheckBox();
        loopToggle = new javax.swing.JCheckBox();
        startOrStopTradingButton = new javax.swing.JButton();
        tradeLengthPanel = new javax.swing.JPanel();
        tradeLengthSpinner = new javax.swing.JSpinner();
        mainTradeMenuBar = new javax.swing.JMenuBar();
        modeMenu = new javax.swing.JMenu();
        tradeRepeatAndRectify = new javax.swing.JRadioButtonMenuItem();
        tradeRandomModify = new javax.swing.JRadioButtonMenuItem();
        tradeAbstract = new javax.swing.JRadioButtonMenuItem();
        tradeWithAMusician = new javax.swing.JRadioButtonMenuItem();
        tradeGrammarSolo = new javax.swing.JRadioButtonMenuItem();
        tradeStore = new javax.swing.JRadioButtonMenuItem();
        tradeMusicianMenu = new javax.swing.JMenu();
        tradeGrammarMenu = new javax.swing.JMenu();
        tradePlayMenu = new javax.swing.JMenu();
        tradePlayMenuItem = new javax.swing.JMenuItem();
        tradeStopMenuItem = new javax.swing.JMenuItem();

        setTitle("Impro-Visor Active Trading");
        setBackground(new java.awt.Color(204, 204, 255));
        setBounds(new java.awt.Rectangle(25, 25, 800, 350));
        setLocation(new java.awt.Point(25, 25));
        setMaximumSize(new java.awt.Dimension(800, 200));
        setMinimumSize(new java.awt.Dimension(800, 200));
        setPreferredSize(new java.awt.Dimension(800, 200));
        setSize(new java.awt.Dimension(800, 200));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                activeTradingWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                activeTradingWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        leadSelectors.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        leadSelectors.setMaximumSize(new java.awt.Dimension(200, 100));
        leadSelectors.setMinimumSize(new java.awt.Dimension(200, 100));
        leadSelectors.setPreferredSize(new java.awt.Dimension(200, 100));
        leadSelectors.setLayout(new java.awt.GridBagLayout());

        leadingSelector.add(userFirstButton);
        userFirstButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        userFirstButton.setSelected(true);
        userFirstButton.setText("User First");
        userFirstButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userFirstButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        leadSelectors.add(userFirstButton, gridBagConstraints);

        leadingSelector.add(improvisorFirstButton);
        improvisorFirstButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        improvisorFirstButton.setText("Impro-Visor First");
        improvisorFirstButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                improvisorFirstButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        leadSelectors.add(improvisorFirstButton, gridBagConstraints);

        switchToPassiveTradingButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        switchToPassiveTradingButton.setText("Stop and Switch to Passive Trading");
        switchToPassiveTradingButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        switchToPassiveTradingButton.setMaximumSize(new java.awt.Dimension(270, 21));
        switchToPassiveTradingButton.setMinimumSize(new java.awt.Dimension(270, 21));
        switchToPassiveTradingButton.setPreferredSize(new java.awt.Dimension(270, 21));
        switchToPassiveTradingButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                switchToPassiveTradingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        leadSelectors.add(switchToPassiveTradingButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.4;
        getContentPane().add(leadSelectors, gridBagConstraints);

        modePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        modePanel.setMaximumSize(new java.awt.Dimension(200, 100));
        modePanel.setMinimumSize(new java.awt.Dimension(200, 100));
        modePanel.setPreferredSize(new java.awt.Dimension(200, 100));
        modePanel.setLayout(new java.awt.GridBagLayout());

        modeStatus.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        modeStatus.setText("Mode: ___ ");
        modeStatus.setMaximumSize(new java.awt.Dimension(200, 30));
        modeStatus.setMinimumSize(new java.awt.Dimension(200, 30));
        modeStatus.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        modePanel.add(modeStatus, gridBagConstraints);

        grammarStatus.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        grammarStatus.setText("Grammar: ___    ");
        grammarStatus.setMaximumSize(new java.awt.Dimension(200, 30));
        grammarStatus.setMinimumSize(new java.awt.Dimension(200, 30));
        grammarStatus.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        modePanel.add(grammarStatus, gridBagConstraints);

        transformStatus.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        transformStatus.setText("Transform: ___ ");
        transformStatus.setMaximumSize(new java.awt.Dimension(200, 30));
        transformStatus.setMinimumSize(new java.awt.Dimension(200, 30));
        transformStatus.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        modePanel.add(transformStatus, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.7;
        getContentPane().add(modePanel, gridBagConstraints);

        controlsPanel.setMaximumSize(new java.awt.Dimension(200, 50));
        controlsPanel.setMinimumSize(new java.awt.Dimension(200, 50));
        controlsPanel.setPreferredSize(new java.awt.Dimension(200, 50));
        controlsPanel.setLayout(new java.awt.GridBagLayout());

        processTimeSelector.setBackground(new java.awt.Color(238, 238, 238));
        processTimeSelector.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        processTimeSelector.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        processTimeSelector.setText("0.5");
        processTimeSelector.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Processing time (in beats)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        processTimeSelector.setMaximumSize(new java.awt.Dimension(200, 50));
        processTimeSelector.setMinimumSize(new java.awt.Dimension(200, 50));
        processTimeSelector.setPreferredSize(new java.awt.Dimension(200, 50));
        processTimeSelector.addCaretListener(new javax.swing.event.CaretListener()
        {
            public void caretUpdate(javax.swing.event.CaretEvent evt)
            {
                processTimeSelectorCaretUpdate(evt);
            }
        });
        processTimeSelector.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                processTimeSelectorFocusLost(evt);
            }
        });
        processTimeSelector.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                processTimeSelectorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        controlsPanel.add(processTimeSelector, gridBagConstraints);

        tempoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tempo (Beats per Minute)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        tempoPanel.setLayout(new java.awt.GridBagLayout());

        tempoLabel.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        tempoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempoLabel.setText("120");
        tempoLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.3;
        tempoPanel.add(tempoLabel, gridBagConstraints);

        tempoSlider.setMaximum(300);
        tempoSlider.setMinimum(30);
        tempoSlider.setValue(120);
        tempoSlider.setMaximumSize(new java.awt.Dimension(150, 29));
        tempoSlider.setMinimumSize(new java.awt.Dimension(150, 29));
        tempoSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                tempoSliderStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.7;
        tempoPanel.add(tempoSlider, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        controlsPanel.add(tempoPanel, gridBagConstraints);

        volumePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Response Volume", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        volumePanel.setLayout(new java.awt.GridBagLayout());

        volumeLabel.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        volumeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeLabel.setText("120");
        volumeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.3;
        volumePanel.add(volumeLabel, gridBagConstraints);

        volumeSlider.setMaximumSize(new java.awt.Dimension(150, 29));
        volumeSlider.setMinimumSize(new java.awt.Dimension(150, 29));
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                volumeSliderStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        volumePanel.add(volumeSlider, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        controlsPanel.add(volumePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(controlsPanel, gridBagConstraints);

        playbackControls.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        playbackControls.setMinimumSize(new java.awt.Dimension(261, 50));
        playbackControls.setPreferredSize(new java.awt.Dimension(261, 50));
        playbackControls.setLayout(new java.awt.GridBagLayout());

        countToggle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        countToggle.setText("Count In");
        countToggle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                countToggleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        playbackControls.add(countToggle, gridBagConstraints);

        loopToggle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        loopToggle.setSelected(true);
        loopToggle.setText("Loop");
        loopToggle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loopToggleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        playbackControls.add(loopToggle, gridBagConstraints);

        startOrStopTradingButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        startOrStopTradingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/play.gif"))); // NOI18N
        startOrStopTradingButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        startOrStopTradingButton.setLabel("Start Trading");
        startOrStopTradingButton.setMaximumSize(new java.awt.Dimension(140, 28));
        startOrStopTradingButton.setMinimumSize(new java.awt.Dimension(140, 28));
        startOrStopTradingButton.setPreferredSize(new java.awt.Dimension(140, 28));
        startOrStopTradingButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startOrStopTradingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        playbackControls.add(startOrStopTradingButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(playbackControls, gridBagConstraints);

        tradeLengthPanel.setMaximumSize(new java.awt.Dimension(200, 123));
        tradeLengthPanel.setLayout(new java.awt.GridBagLayout());

        tradeLengthSpinner.setModel(new javax.swing.SpinnerNumberModel(4, 1, null, 1));
        tradeLengthSpinner.setToolTipText("The number of bars in melody.");
        tradeLengthSpinner.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Length of Trade (bars)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 12))); // NOI18N
        tradeLengthSpinner.setMinimumSize(new java.awt.Dimension(200, 50));
        tradeLengthSpinner.setPreferredSize(new java.awt.Dimension(200, 50));
        tradeLengthSpinner.setValue(new Integer(4));
        tradeLengthSpinner.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                tradeLengthSpinnerlengthOfTradeSet(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        tradeLengthPanel.add(tradeLengthSpinner, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.25;
        getContentPane().add(tradeLengthPanel, gridBagConstraints);

        mainTradeMenuBar.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N

        modeMenu.setText("Trading Mode");

        modeSelector.add(tradeRepeatAndRectify);
        tradeRepeatAndRectify.setText("Repeat and Rectify");
        modeMenu.add(tradeRepeatAndRectify);

        modeSelector.add(tradeRandomModify);
        tradeRandomModify.setText("Modify and Rectify");
        tradeRandomModify.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tradeRandomModifyActionPerformed(evt);
            }
        });
        modeMenu.add(tradeRandomModify);

        modeSelector.add(tradeAbstract);
        tradeAbstract.setText("Use Abstract Melody");
        modeMenu.add(tradeAbstract);

        modeSelector.add(tradeWithAMusician);
        tradeWithAMusician.setSelected(true);
        tradeWithAMusician.setText("Use Transform");
        modeMenu.add(tradeWithAMusician);
        tradeWithAMusician.getAccessibleContext().setAccessibleDescription("");

        modeSelector.add(tradeGrammarSolo);
        tradeGrammarSolo.setText("Use Grammar");
        modeMenu.add(tradeGrammarSolo);

        modeSelector.add(tradeStore);
        tradeStore.setText("Chop and Memorize");
        modeMenu.add(tradeStore);

        mainTradeMenuBar.add(modeMenu);

        tradeMusicianMenu.setText("Transform ");
        mainTradeMenuBar.add(tradeMusicianMenu);

        tradeGrammarMenu.setText("Grammar");
        mainTradeMenuBar.add(tradeGrammarMenu);

        tradePlayMenu.setText("Play");

        tradePlayMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        tradePlayMenuItem.setText("Trade");
        tradePlayMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tradePlayMenuItemActionPerformed(evt);
            }
        });
        tradePlayMenu.add(tradePlayMenuItem);

        tradeStopMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, 0));
        tradeStopMenuItem.setText("Stop");
        tradeStopMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tradeStopMenuItemActionPerformed(evt);
            }
        });
        tradePlayMenu.add(tradeStopMenuItem);

        mainTradeMenuBar.add(tradePlayMenu);

        setJMenuBar(mainTradeMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFirstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFirstButtonActionPerformed
        updateIsUserLeading();
    }//GEN-LAST:event_userFirstButtonActionPerformed

    private void improvisorFirstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_improvisorFirstButtonActionPerformed
        updateIsUserLeading();
    }//GEN-LAST:event_improvisorFirstButtonActionPerformed

    private void processTimeSelectorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_processTimeSelectorCaretUpdate
        updateProcessTime();
    }//GEN-LAST:event_processTimeSelectorCaretUpdate

    private void processTimeSelectorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_processTimeSelectorFocusLost
        updateProcessTimeText();
    }//GEN-LAST:event_processTimeSelectorFocusLost

    private void processTimeSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTimeSelectorActionPerformed
        updateProcessTimeText();
    }//GEN-LAST:event_processTimeSelectorActionPerformed

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeSliderStateChanged
        updateVolume();
    }//GEN-LAST:event_volumeSliderStateChanged

    private void tempoSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tempoSliderStateChanged
        updateTempo();
    }//GEN-LAST:event_tempoSliderStateChanged

    private void startOrStopTradingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startOrStopTradingButtonActionPerformed
        if( tradingNow )
          {
            stopTrading();
          }
        else
          {
            startTrading();
          }
    }//GEN-LAST:event_startOrStopTradingButtonActionPerformed

    private void loopToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loopToggleActionPerformed
        updateLoop();
    }//GEN-LAST:event_loopToggleActionPerformed

    private void tradeLengthSpinnerlengthOfTradeSet(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tradeLengthSpinnerlengthOfTradeSet
        activeTrading.updateTradeLength("" + tradeLengthSpinner.getValue());
    }//GEN-LAST:event_tradeLengthSpinnerlengthOfTradeSet

    private void tradeRandomModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradeRandomModifyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tradeRandomModifyActionPerformed

    private void countToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countToggleActionPerformed
       updateCountIn();
    }//GEN-LAST:event_countToggleActionPerformed

    private void tradeStopMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradeStopMenuItemActionPerformed
        stopTrading();
    }//GEN-LAST:event_tradeStopMenuItemActionPerformed

    private void tradePlayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradePlayMenuItemActionPerformed
       startTrading();
    }//GEN-LAST:event_tradePlayMenuItemActionPerformed

    private void activeTradingWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_activeTradingWindowClosed
        notate.setNotToTrade();
    }//GEN-LAST:event_activeTradingWindowClosed

    private void activeTradingWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_activeTradingWindowClosing
        notate.setNotToTrade();
    }//GEN-LAST:event_activeTradingWindowClosing

    private void switchToPassiveTradingButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_switchToPassiveTradingButtonActionPerformed
    {//GEN-HEADEREND:event_switchToPassiveTradingButtonActionPerformed
        stopTrading();
        setVisible(false);
        notate.openPassiveTradingWindow();
    }//GEN-LAST:event_switchToPassiveTradingButtonActionPerformed

    private float tryFloat(String number) {
        float newNumber;
        try {
            newNumber = Float.parseFloat(number);
            isUserInputError = false;
        } catch (Exception e) {
            isUserInputError = true;
            newNumber = 0;
        }
        return newNumber;
    }
        
    public void updateGUIComponents() {
        //Integer tradeLength = activeTrading.getMeasures();
        updateProcessTimeText();
        loopToggle.setSelected(activeTrading.getIsLoop());
        int newVol = activeTrading.getVolume();
        volumeSlider.setValue(newVol);
        volumeLabel.setText(newVol + "%");
        userFirstButton.setSelected(activeTrading.getIsUserLeading());
        Double newTempo = activeTrading.getTempo();
        tempoSlider.setValue(newTempo.intValue());
        tempoLabel.setText(newTempo.toString());
        modeStatus.setText("Mode: " + activeTrading.getTradeMode());
        transformStatus.setText("Transform: " + activeTrading.getMusician());
        String gramm = activeTrading.getGrammar();
        tradeGrammarMenu.setText(gramm);
        grammarStatus.setText("Grammar: " + gramm);
    }

    public void tradingDialogOpened() {
        activeTrading.setNotateDefaults();
        updateGUIComponents();
    }


    private void startTradingButtonPressed() {

        startTrading();
    }
    
    private void startTrading()
    {
         if (!isUserInputError) {
            updateMusician();
            updateTradeMode();
            activeTrading.startTrading(); 
         }
         tradingNow = true;
    }
    
    private void stopTrading()
    {
        activeTrading.stopTrading(); 
        tradingNow = false;
    }
    
    private void updateProcessTimeText() {
        int slotsForProcessing = activeTrading.getSlotsForProcessing();
        if (slotsForProcessing == 1) {
            processTimeSelector.setText("0.0");
        } else {
            Double newBeatVal = activeTrading.slotsToBeats(slotsForProcessing);
            processTimeSelector.setText(newBeatVal.toString());
        }
    }

    private void updateTradeMode() {
        String newMode = getFromDropDown(modeMenu);
        activeTrading.setTradeMode(newMode);
        modeStatus.setText("Mode: " + newMode);
    }

    private void updateLoop() {
        activeTrading.setLoop(loopToggle.isSelected());
    }
    
    private void updateCountIn() {
      notate.setCountIn(countToggle.isSelected());
    }

    private void updateTempo() {
        Integer tempo = tempoSlider.getValue();
        tempoLabel.setText(tempo.toString());
        activeTrading.setTempo(tempo);
    }

    private void updateMusician() {
        String newMusician = getFromDropDown(tradeMusicianMenu);
        activeTrading.setMusician(newMusician);
        transformStatus.setText("Transform File: " + newMusician);
    }

    private void updateVolume() {
        Integer newVol = volumeSlider.getValue();
        activeTrading.setVolume(newVol);
        volumeLabel.setText(newVol + "%");
    }

    private void updateProcessTime() {
        activeTrading.setProcessTime(tryFloat(processTimeSelector.getText()));
    }

    private void updateIsUserLeading() {
        userFirst = userFirstButton.isSelected();
        activeTrading.setIsUserLeading(userFirst);
        // Force countIn off if Impro-Visor is first
        if( !userFirst )
        {
            countToggle.setSelected(false);
            updateCountIn();
        }
      countToggle.setEnabled(userFirst);
   }

    private String getFromDropDown(JMenu menu) {
        Component[] modes = menu.getMenuComponents();
        String selection = "";
        for (Component mode : modes) {
            JRadioButtonMenuItem modeButton = (JRadioButtonMenuItem) mode;
            if (modeButton.isSelected()) {
                selection = modeButton.getText();
                //System.out.println(selection);
                return selection;
            }
        }
        return selection;
    }

    public void refreshSelectedGrammar(String gram) {
        tradeGrammarMenu.setText(gram);
        grammarStatus.setText("Grammar: " + activeTrading.getGrammar());
    }

    private void populateMusicianList() {
        File directory = ImproVisor.getTransformDirectory();
        //System.out.println("populating from " + directory);
        if (directory.isDirectory()) {
            String fileName[] = directory.list();

            // 6-25-13 Hayden Blauzvern
            // Fix for Linux, where the file list is not in alphabetic order
            Arrays.sort(fileName, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.toUpperCase().compareTo(s2.toUpperCase());
                }

            });

            // Add names of grammar files
            for (String name : fileName) {
                if (name.endsWith(TransformFilter.EXTENSION)) {
                    int len = name.length();
                    String stem = name.substring(0, len - TransformFilter.EXTENSION.length());
                    JRadioButtonMenuItem newMusician = new JRadioButtonMenuItem();
                    newMusician.setText(stem);
                    newMusician.addActionListener(this);
                    newMusician.setSelected(true);
                    transformFileSelector.add(newMusician);
                    tradeMusicianMenu.add(newMusician);

                }
            }
        }
        updateMusician();
    }

    public void tradingStarted() {
        startOrStopTradingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/stop.gif")));
        startOrStopTradingButton.setText("Stop Trading");
    }

    public void tradingStopped() {
        startOrStopTradingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/play.gif")));
        startOrStopTradingButton.setText("Start Trading");
    }

    public void trackPlay(ActionEvent e) {
        activeTrading.trackPlay(e);
    }

    public void actionPerformed(ActionEvent e) {
        updateMusician();
        updateTradeMode();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JCheckBox countToggle;
    private javax.swing.ButtonGroup grammarGroup;
    private javax.swing.JLabel grammarStatus;
    private javax.swing.JRadioButton improvisorFirstButton;
    private javax.swing.JPanel leadSelectors;
    private javax.swing.ButtonGroup leadingSelector;
    private javax.swing.JCheckBox loopToggle;
    private javax.swing.JMenuBar mainTradeMenuBar;
    private javax.swing.JMenu modeMenu;
    private javax.swing.JPanel modePanel;
    private javax.swing.ButtonGroup modeSelector;
    private javax.swing.JLabel modeStatus;
    private javax.swing.JPanel playbackControls;
    private javax.swing.JTextField processTimeSelector;
    private javax.swing.JButton startOrStopTradingButton;
    private javax.swing.JButton switchToPassiveTradingButton;
    private javax.swing.JLabel tempoLabel;
    private javax.swing.JPanel tempoPanel;
    private javax.swing.JSlider tempoSlider;
    private javax.swing.JRadioButtonMenuItem tradeAbstract;
    private javax.swing.JMenu tradeGrammarMenu;
    private javax.swing.JRadioButtonMenuItem tradeGrammarSolo;
    private javax.swing.JPanel tradeLengthPanel;
    private javax.swing.JSpinner tradeLengthSpinner;
    private javax.swing.JMenu tradeMusicianMenu;
    private javax.swing.JMenu tradePlayMenu;
    private javax.swing.JMenuItem tradePlayMenuItem;
    private javax.swing.JRadioButtonMenuItem tradeRandomModify;
    private javax.swing.JRadioButtonMenuItem tradeRepeatAndRectify;
    private javax.swing.JMenuItem tradeStopMenuItem;
    private javax.swing.JRadioButtonMenuItem tradeStore;
    private javax.swing.JRadioButtonMenuItem tradeWithAMusician;
    private javax.swing.ButtonGroup transformFileSelector;
    private javax.swing.JLabel transformStatus;
    private javax.swing.JRadioButton userFirstButton;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JPanel volumePanel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
