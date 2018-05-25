
package org.picfight.dcr.code.process;

import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class RegextpTest {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();

		final String input = "decred/$DOCKER_IMAGE_TAG";

		final String res = input.replaceAll("\\$D", "\\$X");

		L.d(res);
	}

}
