
package org.picfight.dcr.code.process;

import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class RegextpTest {

	public static void main (final String[] args) {
		ScarabeiDesktop.deploy();
		{
			final String input = "decred/$DOCKER_IMAGE_TAG";

			final String res = input.replaceAll("\\$D", "\\$X");

			L.d(res);
		}
		{
			final String input = "123|456";

			final String res = input.replaceAll("\\|4", "\\|X");

			L.d(res);
		}

		{
			final String input = "-\"123456\"-";

			final String res = input.replaceAll("\"123456\"", "\"xxxxxxx\"");

			L.d(res);
		}

		{
			final String input = "CoinsUnspent float64 `json:\\\"dcr_unspent\\\"`";

			final String res = input.replaceAll("\"123456\"", "\"xxxxxxx\"");

			L.d(res);
		}
	}

}
