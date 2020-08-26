/*
 * Copyright 2019 FormDev Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.formdev.flatlaf.demo;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatInspector;
import com.formdev.flatlaf.util.SystemInfo;

/**
 * @author Karl Tauber
 */
public class FlatLafDemo
{
	static final String PREFS_ROOT_PATH = "/flatlaf-demo";
	static final String KEY_TAB = "tab";

	public static void main( String[] args ) {
		// on macOS enable screen menu bar
		if( SystemInfo.isMacOS && System.getProperty( "apple.laf.useScreenMenuBar" ) == null )
			System.setProperty( "apple.laf.useScreenMenuBar", "true" );

		SwingUtilities.invokeLater( () -> {
			DemoPrefs.init( PREFS_ROOT_PATH );

			// enable window decorations
			JFrame.setDefaultLookAndFeelDecorated( true );
			JDialog.setDefaultLookAndFeelDecorated( true );

			// application specific UI defaults
			FlatLaf.registerCustomDefaultsSource( "com.formdev.flatlaf.demo" );

			// set look and feel
			DemoPrefs.initLaf( args );

			// install inspector
			FlatInspector.install( "ctrl shift alt X" );

			// create frame
			DemoFrame frame = new DemoFrame();

			// show frame
			frame.pack();
			frame.setLocationRelativeTo( null );
			frame.setVisible( true );
		} );
	}
}
