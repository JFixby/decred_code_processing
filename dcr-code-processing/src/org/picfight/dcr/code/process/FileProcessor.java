
package org.picfight.dcr.code.process;

import java.io.IOException;

import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.java.ByteArray;
import com.jfixby.scarabei.api.log.L;

public class FileProcessor {

	public static void processFile (final File i, final File o) throws IOException {
		if (i.isFolder()) {
			o.makeFolder();
			return;
		}

		if (isTextFile(i)) {
			String data = i.readToString();

			data = FileProcessor.replace(data);

			o.writeString(data);
		} else {
			final ByteArray data = i.readBytes();
			o.writeBytes(data);
		}
	}

	public static boolean isTextFile (final File i) {
		if (i.extensionIs("png")) {
			return false;
		}
		if (i.extensionIs("jpg")) {
			return false;
		}
		if (i.extensionIs("jpeg")) {
			return false;
		}
		if (i.extensionIs("json")) {
			return true;
		}
		if (i.extensionIs("go")) {
			return true;
		}
		if (i.extensionIs("tmpl")) {
			return true;
		}
		if (i.extensionIs("js")) {
			return true;
		}
		if (i.extensionIs("sh")) {
			return true;
		}
		if (i.extensionIs("css")) {
			return true;
		}
		if (i.extensionIs("lock")) {
			return true;
		}
		if (i.extensionIs("toml")) {
			return true;
		}
		if (i.extensionIs("md")) {
			return true;
		}
		if (i.extensionIs("xml")) {
			return true;
		}
		if (i.extensionIs("exe")) {
			return false;
		}
		if (i.extensionIs("svg")) {
			return false;
		}
		if (i.extensionIs("ico")) {
			return false;
		}
		if (i.extensionIs("bin")) {
			return false;
		}
		if (i.extensionIs("bin")) {
			return false;
		}
		if (i.extensionIs("db")) {
			return false;
		}
		L.e("unknown file type", i.getExtension());
		return true;
	}

	public static String replace (String data) {
		data = data.replaceAll("DCR", "PFC");

		data = data.replaceAll("decred\\\\dcrd", "picfight\\\\pfcd");
		data = data.replaceAll("decred\\\\dcrwallet", "picfight\\\\pfcwallet");

		data = data.replaceAll("decred/dcrd", "picfight/pfcd");

		data = data.replaceAll("a decred", "a picfight");
		data = data.replaceAll("decred/dcrutil", "picfight/pfcutil");
		data = data.replaceAll("dcrutil", "pfcutil");
		data = data.replaceAll("dcrd", "pfcd");
		data = data.replaceAll("dcrec", "pfcec");
		data = data.replaceAll("dcrj", "pfcj");

		data = data.replaceAll("dcrpg", "pfcpg");
		data = data.replaceAll("dcrsqlite", "pfcsqlite");
		data = data.replaceAll("dcricon", "pfcicon");
		data = data.replaceAll("dcrpassword", "pfcpassword");

		data = data.replaceAll("json:\\\"dcr_", "json:\\\"pfc_");

		data = data.replaceAll(".dcr-total", ".pfc-total");
		data = data.replaceAll(".dcr ", ".pfc ");

		data = data.replaceAll("decred - symbol", "picfight - symbol");

		data = data.replaceAll("-decred:", "-picfight:");
		data = data.replaceAll("-decred ", "-picfight ");
		data = data.replaceAll("-decred-", "-picfight-");

		data = data.replaceAll("name=\"decred\"", "name=\"picfight\"");

		data = data.replaceAll("deCRED", "PicFight coin");

		data = data.replaceAll("right dcr mono", "right pfc mono");

		data = data.replaceAll("Dcrd", "Pfcd");
		data = data.replaceAll("Dcrctl", "Pfcctl");
		data = data.replaceAll("DcrWallet", "PfcWallet");
		data = data.replaceAll("Dcrwallet", "Pfcwallet");

		data = data.replaceAll("decred network", "picfight network");

		data = data.replaceAll("decred supports", "picfight supports");

		data = data.replaceAll("the decred", "the picfight");

		data = data.replaceAll("for decred", "for picfight");

		data = data.replaceAll("decred RPC", "picfight RPC");

		data = data.replaceAll("and decred", "and picfight");

		data = data.replaceAll("decred wallet", "picfight wallet");

		data = data.replaceAll("when decred", "when picfight");

		data = data.replaceAll("decred/decred-release", "picfight/picfight-release");

		data = data.replaceAll("decred-release", "picfight-release");

		data = data.replaceAll("#decred-golang", "#picfight-golang");

		data = data.replaceAll("decred/\\$DOCKER_IMAGE_TAG", "picfight/\\$DOCKER_IMAGE_TAG");

		data = data.replaceAll("/decred/bin", "/picfight/bin");

		data = data.replaceAll("github.com/decred/\\$REPO", "github.com/picfight/\\$REPO");

		data = data.replaceAll("with decred", "with picfight");

		data = data.replaceAll("#decred", "#picfight");
		data = data.replaceAll("=decred", "=picfight");
		data = data.replaceAll("decred.slack.com", "picfight.slack.com");

		data = data.replaceAll("unmined decred", "unmined picfight");
		data = data.replaceAll("associated decred", "associated picfight");
		data = data.replaceAll("of decred", "of picfight");

		data = data.replaceAll("to decred", "to picfight");
		data = data.replaceAll("supported decred", "supported picfight");

		data = data.replaceAll("handling decred", "handling picfight");

		data = data.replaceAll("wrong decred", "wrong picfight");

		data = data.replaceAll("decred.org", "picfight.org");

		data = data.replaceAll("decred/dcrctl", "picfight/pfcctl");
		data = data.replaceAll("dcrctl", "pfcctl");

		data = data.replaceAll("decred/dcrwallet", "picfight/pfcwallet");

		data = data.replaceAll("decred/dcrwallet", "picfight/pfcwallet");
		data = data.replaceAll("dcrwallet", "pfcwallet");

		data = data.replaceAll("decredaddress", "picfightaddress");

		data = data.replaceAll("decred transaction", "picfight coin transaction");
		data = data.replaceAll("spend decred", "spend picfight coin");

		data = data.replaceAll("dcrnet", "pfcnet");

		data = data.replaceAll("decreds", "picfight coins");

		data = data.replaceAll("decred-specific", "picfight-specific");

		data = data.replaceAll("in decred", "in picfight coins");

		data = data.replaceAll("dcrwire", "pfcwire");

		data = data.replaceAll("dcrPK", "pfcPK");

		data = data.replaceAll(PARAMS.DCR_P2P_MAINNET_PORT + ":", PARAMS.PFC_P2P_MAINNET_PORT + ":");
		data = data.replaceAll(PARAMS.DCR_P2P_TESTNET_PORT + ":", PARAMS.PFC_P2P_TESTNET_PORT + ":");
		data = data.replaceAll(PARAMS.DCR_RPC_MAINNET_PORT + ":", PARAMS.PFC_RPC_MAINNET_PORT + ":");
		data = data.replaceAll(PARAMS.DCR_RPC_TESTNET_PORT + ":", PARAMS.PFC_RPC_TESTNET_PORT + ":");

		data = data.replaceAll(PARAMS.DCR_P2P_MAINNET_PORT + "\\|", PARAMS.PFC_P2P_MAINNET_PORT + "\\|");
		data = data.replaceAll(PARAMS.DCR_P2P_TESTNET_PORT + "\\|", PARAMS.PFC_P2P_TESTNET_PORT + "\\|");
		data = data.replaceAll(PARAMS.DCR_RPC_MAINNET_PORT + "\\|", PARAMS.PFC_RPC_MAINNET_PORT + "\\|");
		data = data.replaceAll(PARAMS.DCR_RPC_TESTNET_PORT + "\\|", PARAMS.PFC_RPC_TESTNET_PORT + "\\|");

		data = data.replaceAll(":" + PARAMS.DCR_P2P_MAINNET_PORT, ":" + PARAMS.PFC_P2P_MAINNET_PORT + "");
		data = data.replaceAll(":" + PARAMS.DCR_P2P_TESTNET_PORT + "", ":" + PARAMS.PFC_P2P_TESTNET_PORT + "");
		data = data.replaceAll(":" + PARAMS.DCR_RPC_MAINNET_PORT + "", ":" + PARAMS.PFC_RPC_MAINNET_PORT + "");
		data = data.replaceAll(":" + PARAMS.DCR_RPC_TESTNET_PORT + "", ":" + PARAMS.PFC_RPC_TESTNET_PORT + "");

		data = data.replaceAll(": " + PARAMS.DCR_P2P_MAINNET_PORT, ": " + PARAMS.PFC_P2P_MAINNET_PORT + "");
		data = data.replaceAll(": " + PARAMS.DCR_P2P_TESTNET_PORT + "", ": " + PARAMS.PFC_P2P_TESTNET_PORT + "");
		data = data.replaceAll(": " + PARAMS.DCR_RPC_MAINNET_PORT + "", ": " + PARAMS.PFC_RPC_MAINNET_PORT + "");
		data = data.replaceAll(": " + PARAMS.DCR_RPC_TESTNET_PORT + "", ": " + PARAMS.PFC_RPC_TESTNET_PORT + "");

		data = data.replaceAll(" " + PARAMS.DCR_P2P_MAINNET_PORT + " ", " " + PARAMS.PFC_P2P_MAINNET_PORT + " ");
		data = data.replaceAll(" " + PARAMS.DCR_P2P_TESTNET_PORT + " ", " " + PARAMS.PFC_P2P_TESTNET_PORT + " ");
		data = data.replaceAll(" " + PARAMS.DCR_RPC_MAINNET_PORT + " ", " " + PARAMS.PFC_RPC_MAINNET_PORT + " ");
		data = data.replaceAll(" " + PARAMS.DCR_RPC_TESTNET_PORT + " ", " " + PARAMS.PFC_RPC_TESTNET_PORT + " ");

		data = data.replaceAll("\"" + PARAMS.DCR_P2P_MAINNET_PORT + "\"", "\"" + PARAMS.PFC_P2P_MAINNET_PORT + "\"");
		data = data.replaceAll("\"" + PARAMS.DCR_P2P_TESTNET_PORT + "\"", "\"" + PARAMS.PFC_P2P_TESTNET_PORT + "\"");
		data = data.replaceAll("\"" + PARAMS.DCR_RPC_MAINNET_PORT + "\"", "\"" + PARAMS.PFC_RPC_MAINNET_PORT + "\"");
		data = data.replaceAll("\"" + PARAMS.DCR_RPC_TESTNET_PORT + "\"", "\"" + PARAMS.PFC_RPC_TESTNET_PORT + "\"");

		data = data.replaceAll("dcrchain", "pfcchain");

		data = data.replaceAll("dcr work", "pfc work");

		data = data.replaceAll("dcr/kb", "pfc/kb");
		data = data.replaceAll("decred/dcrrpcclient", "picfight/pfcrpcclient");
		data = data.replaceAll("dcrrpcclient", "pfcrpcclient");

		data = data.replaceAll("The Decred developers", "#DEVS#");
		data = data.replaceAll("The Decred Developers", "#DEVS#");
		data = data.replaceAll("The Decred Authors", "#DEVS#");

		data = data.replaceAll("Decred", "PicFight");

		data = data.replaceAll("#DEVS#", "The Decred developers");

		return data;
	}

}
