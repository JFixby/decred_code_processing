
package org.picfight.dcr.code.process;

import java.io.IOException;

import com.jfixby.scarabei.api.collections.Collections;
import com.jfixby.scarabei.api.collections.List;
import com.jfixby.scarabei.api.collections.Map;
import com.jfixby.scarabei.api.file.File;
import com.jfixby.scarabei.api.file.FilesList;
import com.jfixby.scarabei.api.file.LocalFile;
import com.jfixby.scarabei.api.file.LocalFileSystem;
import com.jfixby.scarabei.api.log.L;
import com.jfixby.scarabei.api.sys.Sys;
import com.jfixby.scarabei.red.desktop.ScarabeiDesktop;

public class RenameFiles {

	public static void main (final String[] args) throws IOException {
		ScarabeiDesktop.deploy();

// final String token = "github.com/decred/";
		final String token = "dcr";
		final String replacement = "pfcd";

		final String targetPath = "D:\\PICFIGHT\\src\\github.com\\picfight\\pfcwallet\\";
		final LocalFile target = LocalFileSystem.newFile(targetPath);
		final FilesList direct = target.listDirectChildren();

		final List<File> directList = direct.toList().filter(file -> !file.getName().equals(".git"));

		final List<File> allFiles = Collections.newList();

		for (final File f : directList) {
			if (f.isFile()) {
				allFiles.add(f);
			} else {
				final FilesList list = f.listAllChildren();
				allFiles.addAll(list);
				allFiles.add(f);
			}
		}

// L.d("allFiles", allFiles);
		for (final File f : allFiles) {
			final String oldName = f.getName();
			if (oldName.contains("dcr")) {
				final String new_name = oldName.replaceAll("dcr", "pfc");
				L.d("rename", f + " -> " + new_name);
				f.rename(new_name);
				L.d("      ", f);

			}
			if (f.isFile()) {
				if (f.getName().startsWith("CONTRIBUTORS")) {
					continue;
				}
				final String data = f.readToString();
				if (data.contains("dcr")) {
					final String newData = data.replaceAll("dcr", "pfc");
// f.writeString(newData);
// L.d("write file", f);
				}
				if (data.contains("DCR")) {
					final String newData = data.replaceAll("DCR", "PFC");
// f.writeString(newData);
// L.d("write file", f);
				}
				if (data.contains("decred")) {
					final String newData = data.replaceAll("decred", "picfight");
// f.writeString(newData);
// L.d("write file", f);
				}
				if (data.contains("Decred")) {
					if (f.extensionIs("md")) {
						final String newData = data.replaceAll("Decred", "PicFight");
// f.writeString(newData);
// L.d("write file", f);
					}
				}
			}
		}

		Sys.exit();
// target.li
		final FilesList goFiles = target.listAllChildren(file -> {
			try {
				return (file.extensionIs("go")//
					|| file.extensionIs("md")//
					|| file.extensionIs("conf")//
					|| file.extensionIs("conf")//
					|| file.extensionIs("xml")//
					|| file.extensionIs("sh")//
					|| file.extensionIs("service")//
				) && file.readToString().contains(token);
			} catch (final IOException e) {
				e.printStackTrace();
				return false;
			}
		});

		L.d("go files", goFiles);
		final Map<String, String> replacers = Collections.newMap();

	}

}
