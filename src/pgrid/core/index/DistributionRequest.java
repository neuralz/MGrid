/**
 *
 * Copyright (c) 2002-2008 The P-Grid Team, All Rights Reserved.
 *
 * This file is part of the P-Grid package.
 * P-Grid homepage: http://www.p-grid.org/
 *  
 * The P-Grid package is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * The P-Grid package is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with the P-Grid package.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package pgrid.core.index;

import java.util.Collection;

/**
 * A distribution request.
 *
 * @author <a href="mailto:Roman Schmidt <Roman.Schmidt@epfl.ch>">Roman Schmidt</a>
 * @version 1.0.0
 */
public class DistributionRequest  implements DistributionRequestInt  {
	private Collection mItems = null;
	
	private CSVIndexTable mCSVIndexTable = null;

	private short mRequest = -1;

	private long mStartTime;

	public DistributionRequest(short request, Collection items) {
		mRequest = request;
		mItems = items;
		mStartTime = System.currentTimeMillis();
	}

	public DistributionRequest(short request, CSVIndexTable csvItems) {
		mRequest = request;
		mCSVIndexTable = csvItems;
		mStartTime = System.currentTimeMillis();
	}

	public Collection getItems() {
		return mItems;
	}
	
	public CSVIndexTable getCSVIndexTable(){
		return mCSVIndexTable;
	}

	public short getRequest() {
		return mRequest;
	}

	public long getStartTime() {
		return mStartTime;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		if(mItems != null){
			mItems.clear();
			mItems = null;
		}
		if(mCSVIndexTable != null) mCSVIndexTable.delete();
	}

}
