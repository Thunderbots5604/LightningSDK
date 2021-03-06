/* Copyright (C) 2015-2016 Thunderbots Robotics
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.thunderbots.lightning.control;

/**
 * The {@code JoystickButton} enumeration contains all buttons that can be pressed on the
 * joysticks.
 *
 * @author Zach Ohara
 * @author Pranav Mathur
 */
public enum JoystickButton {

	A,
	B,
	X,
	Y,

	DPAD_UP,
	DPAD_DOWN,
	DPAD_LEFT,
	DPAD_RIGHT,

	LEFT_STICK,
	RIGHT_STICK,

	LEFT_BUMPER,
	RIGHT_BUMPER;

	@Override
	public String toString() {
		return this.name();
	}

}
