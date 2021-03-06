/**
 * This file is Copyright © 2008 Software Craftsmen Limited. All Rights Reserved.
 */
package com.softwarecraftsmen.dns.client.serverAddressFinders;

import static com.softwarecraftsmen.dns.SerializableInternetProtocolAddress.InternetProtocolVersion6LocalHost;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import java.util.List;

public class InternetProtocolVersion6LocalHostServerAddressFinder implements ServerAddressFinder
{
	public static final InternetProtocolVersion6LocalHostServerAddressFinder InternetProtocolVersion6LocalHostServerAddressFinderOnPort53 = new InternetProtocolVersion6LocalHostServerAddressFinder(StandardUnicastDnsServerPort);
	private final List<InetSocketAddress> addresses;

	public InternetProtocolVersion6LocalHostServerAddressFinder(final int dnsServerPort)
	{
		addresses = unmodifiableList(new ArrayList<InetSocketAddress>()
		{{
			add(new InetSocketAddress(InternetProtocolVersion6LocalHost.address, dnsServerPort));
		}});
	}

	@NotNull
	public List<InetSocketAddress> find()
	{
		return addresses;
	}
}