
package org.picfight.dcr.code.process;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFile;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.util.Utils;
import com.jfixby.scarabei.api.util.path.RelativePath;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class PFCD_builder {

	public static void main (final String[] args) throws IOException {

		ScarabeiDesktop.deploy();

		final String goWorkspacePath = "D:\\PICFIGHT";
		final LocalFile goWS = LocalFileSystem.newFile(goWorkspacePath);

		final File dcrd_project = goWS.child("src").child("github.com").child("decred").child("dcrd");
		dcrd_project.checkExists();

		final File pfcd_project = goWS.child("src").child("github.com").child("picfight").child("pfcd");
		pfcd_project.checkExists();

		clearProject(pfcd_project);
// Sys.exit();

		final List<File> input = listProjectFiles(dcrd_project);
// L.d("input", input);

		final RelativePath inputPrefix = dcrd_project.getAbsoluteFilePath().getRelativePath();
		final RelativePath outputPrefix = pfcd_project.getAbsoluteFilePath().getRelativePath();

		for (final File f : input) {
			final RelativePath inputTail = f.getAbsoluteFilePath().getRelativePath().splitAt(inputPrefix.size());
			final RelativePath modPath = Utils
				.newRelativePath(inputTail.toString().replaceAll("dcr", "pfc").replaceAll("decred", "picfight"));
			final File outputPath = pfcd_project.proceed(modPath);
			L.d(">>>", f);
			L.d("   ", outputPath);
			processFile(f, outputPath);
// f.getAbsoluteFilePath().getRelativePath().splitAt(inputPrefix)
		}

	}

	private static void processFile (final File i, final File o) throws IOException {
		if (i.isFolder()) {
			o.makeFolder();
			return;
		}

		String data = i.readToString();
		data = data.replaceAll("DCR", "PFC");
		data = data.replaceAll("decred/dcrd", "picfight/pfcd");
		data = data.replaceAll("a decred", "a picfight");
		data = data.replaceAll("dcrutil", "pfcutil");
		data = data.replaceAll("dcrd", "pfcd");
		data = data.replaceAll("dcrec", "pfcec");
		data = data.replaceAll("dcrj", "pfcj");

		data = data.replaceAll("decred network", "picfight network");

		data = data.replaceAll("the decred", "the picfight");

		data = data.replaceAll("for decred", "for picfight");

		data = data.replaceAll("when decred", "when picfight");

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

		o.writeString(data);
	}

	private static List<File> listProjectFiles (final File project) throws IOException {
		final List<File> result = Collections.newList();
		final FilesList child = project.listDirectChildren()
			.filter(file -> !file.getName().equals(".git") && !file.getName().equals("vendor"));
		for (int i = 0; i < child.size(); i++) {
			final File file = child.getElementAt(i);
			if (file.isFile()) {
				result.add(file);
			} else if (file.isFolder()) {
				final List<File> subfiles = listProjectFiles(file);
				result.addAll(subfiles);
				result.add(file);
			}
		}

		return result;
	}

	private static void clearProject (final File project) throws IOException {
		final FilesList child = project.listDirectChildren().filter(file -> !file.getName().equals(".git"));
// L.d("child", child);
		child.deleteAll();
	}

}
