/**
 * FileIO.java
 * Copyright (C) 2011  Kevin Wang and Shan Shi
 * 
 * This file is part of Minecarft.
 * 
 * Minecarft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Minecarft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Minecarft.  If not, see <http://www.gnu.org/licenses/>.
 */

package minecarft;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author kevin
 */
public class FileIO extends Component {

    public static void saveMap(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            Block[][][] world = World.getInstance().getWorld();
            for (int z = 0; z < world.length; z++) {
                for (int x = 0; x < world[0].length; x++) {
                    for (int y = 0; y < world[0][0].length; y++) {
                        writer.write(z + "," + x + "," + y + "," + world[z][x][y].getType() + "," + world[z][x][y].getBrightness() + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
        }
    }

    public static Block[][][] loadMap(File savefile) {
        Block[][][] world = new Block[World.Z][World.X][World.Y];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(savefile));
            int i = 0;
            while (reader.ready()) {
                StringTokenizer st = new StringTokenizer(reader.readLine(), ",");
                int z = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int type = Integer.parseInt(st.nextToken());
                int brightness = Integer.parseInt(st.nextToken());
                world[z][x][y] = new Block(type, brightness);
                
                // Increment progress bar every 26th of the savefile (128^3 lines)
                if (i++ % (2097152 / 26 - 1) == 0) {
                    Launcher.getInstance().incrementProgressBar();
                }
            }
        } catch (IOException e) {
        }
        return world;
    }
}
